

import java.util.Scanner;

class Book {
    String title, author, genre;
    int id;
    boolean available;
    Book prev, next;

    Book(String t, String a, String g, int i, boolean av) {
        title = t;
        author = a;
        genre = g;
        id = i;
        available = av;
    }
}

public class DoublyLinkedList2 {
    static Book head, tail;
    static Scanner sc = new Scanner(System.in);

    static Book createBook() {
        System.out.print("Title: ");
        String t = sc.nextLine();
        System.out.print("Author: ");
        String a = sc.nextLine();
        System.out.print("Genre: ");
        String g = sc.nextLine();
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        System.out.print("Available (true/false): ");
        boolean av = sc.nextBoolean();
        sc.nextLine();
        return new Book(t, a, g, id, av);
    }

    static void add(int pos) {
        Book b = createBook();
        if (head == null) {
            head = tail = b;
        } else if (pos == 1) {
            b.next = head;
            head.prev = b;
            head = b;
        } else {
            Book temp = head;
            for (int i = 1; i < pos - 1 && temp.next != null; i++)
                temp = temp.next;
            b.next = temp.next;
            b.prev = temp;
            if (temp.next != null)
                temp.next.prev = b;
            else
                tail = b;
            temp.next = b;
        }
        System.out.println("Book added.");
    }

    static void remove() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Book temp = head;
        while (temp != null && temp.id != id)
            temp = temp.next;
        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }
        if (temp.prev == null)
            head = temp.next;
        else
            temp.prev.next = temp.next;
        if (temp.next == null)
            tail = temp.prev;
        else
            temp.next.prev = temp.prev;
        System.out.println("Book removed.");
    }

    static void search() {
        System.out.print("Enter Title or Author: ");
        String s = sc.nextLine();
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(s) ||
                    temp.author.equalsIgnoreCase(s))
                display(temp);
            temp = temp.next;
        }
    }

    static void update() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        Book temp = head;
        while (temp != null && temp.id != id)
            temp = temp.next;
        if (temp == null)
            System.out.println("Book not found.");
        else {
            System.out.print("New Availability (true/false): ");
            temp.available = sc.nextBoolean();
            System.out.println("Updated successfully.");
        }
        sc.nextLine();
    }

    static void display(Book b) {
        System.out.println("\nTitle: " + b.title);
        System.out.println("Author: " + b.author);
        System.out.println("Genre: " + b.genre);
        System.out.println("ID: " + b.id);
        System.out.println("Availability: " + b.available);
    }

    static void show(boolean reverse) {
        Book temp = reverse ? tail : head;
        while (temp != null) {
            display(temp);
            temp = reverse ? temp.prev : temp.next;
        }
    }

    static int count() {
        int c = 0;
        Book temp = head;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        return c;
    }

    public static void main(String[] args) {
        int ch;
        do {
            System.out.println("\n1.Add Beginning  2.Add End");
            System.out.println("3.Add Position   4.Remove");
            System.out.println("5.Search         6.Update");
            System.out.println("7.Forward        8.Reverse");
            System.out.println("9.Count          10.Exit");
            System.out.print("Choice: ");
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1: add(1); break;
                case 2: add(count() + 1); break;
                case 3:
                    System.out.print("Position: ");
                    int p = sc.nextInt();
                    sc.nextLine();
                    if (p >= 1 && p <= count() + 1)
                        add(p);
                    else
                        System.out.println("Invalid position.");
                    break;
                case 4: remove(); break;
                case 5: search(); break;
                case 6: update(); break;
                case 7: show(false); break;
                case 8: show(true); break;
                case 9: System.out.println("Total Books: " + count()); break;
                case 10: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (ch != 10);
        sc.close();
    }
}
