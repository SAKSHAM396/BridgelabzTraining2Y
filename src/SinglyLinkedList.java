
import java.util.Scanner;

class Student {
    int roll, age;
    String name;
    char grade;
    Student next;

    Student(int r, String n, int a, char g) {
        roll = r;
        name = n;
        age = a;
        grade = g;
    }
}

public class SinglyLinkedList {
    static Student head = null;
    static Scanner sc = new Scanner(System.in);

    static void add(int pos) {
        System.out.print("Enter Roll, Name, Age, Grade: ");
        Student n = new Student(sc.nextInt(), sc.next(),
                sc.nextInt(), sc.next().charAt(0));

        if (head == null || pos == 1) {
            n.next = head;
            head = n;
        } else {
            Student t = head;

            for (int i = 1; i < pos - 1 && t.next != null; i++)
                t = t.next;

            n.next = t.next;
            t.next = n;
        }
    }

    static void delete() {
        System.out.print("Enter Roll Number: ");
        int r = sc.nextInt();

        if (head == null) {
            System.out.println("List Empty");
            return;
        }

        if (head.roll == r) {
            head = head.next;
            System.out.println("Deleted");
            return;
        }

        Student t = head;

        while (t.next != null && t.next.roll != r)
            t = t.next;

        if (t.next == null)
            System.out.println("Not Found");
        else {
            t.next = t.next.next;
            System.out.println("Deleted");
        }
    }

    static void search() {
        System.out.print("Enter Roll Number: ");
        int r = sc.nextInt();
        Student t = head;

        while (t != null) {
            if (t.roll == r) {
                System.out.println(t.roll + " " + t.name +
                        " " + t.age + " " + t.grade);
                return;
            }
            t = t.next;
        }
        System.out.println("Not Found");
    }

    static void display() {
        Student t = head;

        if (head == null) {
            System.out.println("List Empty");
            return;
        }

        while (t != null) {
            System.out.println(t.roll + " " + t.name +
                    " " + t.age + " " + t.grade);
            t = t.next;
        }
    }

    static void update() {
        System.out.print("Enter Roll Number: ");
        int r = sc.nextInt();
        Student t = head;

        while (t != null) {
            if (t.roll == r) {
                System.out.print("Enter New Grade: ");
                t.grade = sc.next().charAt(0);
                System.out.println("Updated");
                return;
            }
            t = t.next;
        }
        System.out.println("Not Found");
    }

    public static void main(String[] args) {
        int ch;

        do {
            System.out.println("\n1.Add Beginning");
            System.out.println("2.Add End");
            System.out.println("3.Add Position");
            System.out.println("4.Delete");
            System.out.println("5.Search");
            System.out.println("6.Display");
            System.out.println("7.Update Grade");
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
                case 5: search(); break;
                case 6: display(); break;
                case 7: update(); break;
                case 8: System.out.println("Exit"); break;
                default: System.out.println("Invalid Choice");
            }
        } while (ch != 8);
    }
}
