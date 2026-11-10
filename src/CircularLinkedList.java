
import java.util.Scanner;

class Task {
    int id, priority;
    String name, date;
    Task next;

    Task(int i, String n, int p, String d) {
        id = i;
        name = n;
        priority = p;
        date = d;
    }
}

public class CircularLinkedList {
    static Task head = null, current = null;
    static Scanner sc = new Scanner(System.in);

    static void add(int pos) {
        System.out.print("Enter ID, Name, Priority, Date: ");
        Task n = new Task(sc.nextInt(), sc.next(),
                sc.nextInt(), sc.next());

        if (head == null) {
            head = n;
            n.next = head;
        } else if (pos == 1) {
            Task t = head;

            while (t.next != head)
                t = t.next;

            n.next = head;
            t.next = n;
            head = n;
        } else {
            Task t = head;

            while (pos > 2 && t.next != head) {
                t = t.next;
                pos--;
            }

            n.next = t.next;
            t.next = n;
        }

        if (current == null)
            current = head;
    }

    static void delete() {
        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();

        if (head == null) {
            System.out.println("List Empty");
            return;
        }

        Task t = head, prev = null;

        do {
            if (t.id == id) {
                if (t == head && t.next == head) {
                    head = current = null;
                } else {
                    if (prev == null) {
                        Task last = head;

                        while (last.next != head)
                            last = last.next;

                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = t.next;
                    }

                    if (current == t)
                        current = t.next;
                }

                System.out.println("Deleted");
                return;
            }

            prev = t;
            t = t.next;

        } while (t != head);

        System.out.println("Not Found");
    }

    static void nextTask() {
        if (current == null) {
            System.out.println("No Tasks");
            return;
        }

        System.out.println("Current Task: " + current.name);
        current = current.next;
        System.out.println("Next Task: " + current.name);
    }

    static void display() {
        if (head == null) {
            System.out.println("List Empty");
            return;
        }

        Task t = head;

        do {
            System.out.println(t.id + " " + t.name +
                    " " + t.priority + " " + t.date);
            t = t.next;
        } while (t != head);
    }

    static void search() {
        System.out.print("Enter Priority: ");
        int p = sc.nextInt();

        if (head == null) {
            System.out.println("List Empty");
            return;
        }

        Task t = head;
        boolean found = false;

        do {
            if (t.priority == p) {
                System.out.println(t.id + " " + t.name +
                        " " + t.priority + " " + t.date);
                found = true;
            }

            t = t.next;
        } while (t != head);

        if (!found)
            System.out.println("Not Found");
    }

    public static void main(String[] args) {
        int ch;

        do {
            System.out.println("\n1.Add Beginning");
            System.out.println("2.Add End");
            System.out.println("3.Add Position");
            System.out.println("4.Delete Task");
            System.out.println("5.Next Task");
            System.out.println("6.Display Tasks");
            System.out.println("7.Search Priority");
            System.out.println("8.Exit");

            ch = sc.nextInt();

            switch (ch) {
                case 1: add(1); break;
                case 2: add(999); break;
                case 3:
                    System.out.print("Enter Position: ");
                    add(sc.nextInt());
                    break;
                case 4: delete(); break;
                case 5: nextTask(); break;
                case 6: display(); break;
                case 7: search(); break;
                case 8: System.out.println("Exit"); break;
                default: System.out.println("Invalid Choice");
            }

        } while (ch != 8);
    }
}
