
import java.util.Scanner;

class Movie {
    String title, director;
    int year;
    double rating;
    Movie next, prev;

    Movie(String t, String d, int y, double r) {
        title = t;
        director = d;
        year = y;
        rating = r;
    }
}

public class DoublyLinkedList {
    static Movie head = null, tail = null;
    static Scanner sc = new Scanner(System.in);

    static void add(int pos) {
        System.out.print("Enter Title, Director, Year, Rating: ");
        Movie n = new Movie(sc.next(), sc.next(),
                sc.nextInt(), sc.nextDouble());

        if (head == null) {
            head = tail = n;
        } else if (pos == 1) {
            n.next = head;
            head.prev = n;
            head = n;
        } else {
            Movie t = head;

            while (pos > 2 && t.next != null) {
                t = t.next;
                pos--;
            }

            n.next = t.next;
            n.prev = t;

            if (t.next != null)
                t.next.prev = n;
            else
                tail = n;

            t.next = n;
        }
    }

    static void delete() {
        System.out.print("Enter Movie Title: ");
        String s = sc.next();
        Movie t = head;

        while (t != null && !t.title.equals(s))
            t = t.next;

        if (t == null) {
            System.out.println("Not Found");
            return;
        }

        if (t.prev == null)
            head = t.next;
        else
            t.prev.next = t.next;

        if (t.next == null)
            tail = t.prev;
        else
            t.next.prev = t.prev;

        System.out.println("Deleted");
    }

    static void search(int ch) {
        System.out.print("Enter Director or Rating: ");
        String s = sc.next();
        Movie t = head;
        boolean found = false;

        while (t != null) {
            if ((ch == 1 && t.director.equals(s)) ||
                    (ch == 2 && t.rating == Double.parseDouble(s))) {
                show(t);
                found = true;
            }
            t = t.next;
        }

        if (!found)
            System.out.println("Not Found");
    }

    static void show(Movie t) {
        System.out.println(t.title + " " + t.director +
                " " + t.year + " " + t.rating);
    }

    static void display(int ch) {
        Movie t = (ch == 1) ? head : tail;

        while (t != null) {
            show(t);
            t = (ch == 1) ? t.next : t.prev;
        }
    }

    static void update() {
        System.out.print("Enter Movie Title: ");
        String s = sc.next();
        Movie t = head;

        while (t != null) {
            if (t.title.equals(s)) {
                System.out.print("Enter New Rating: ");
                t.rating = sc.nextDouble();
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
            System.out.println("5.Search Director");
            System.out.println("6.Search Rating");
            System.out.println("7.Forward Display");
            System.out.println("8.Reverse Display");
            System.out.println("9.Update Rating");
            System.out.println("10.Exit");

            ch = sc.nextInt();

            switch (ch) {
                case 1: add(1); break;
                case 2: add(999); break;
                case 3:
                    System.out.print("Enter Position: ");
                    add(sc.nextInt());
                    break;
                case 4: delete(); break;
                case 5: search(1); break;
                case 6: search(2); break;
                case 7: display(1); break;
                case 8: display(2); break;
                case 9: update(); break;
                case 10: System.out.println("Exit"); break;
                default: System.out.println("Invalid Choice");
            }
        } while (ch != 10);
    }
}
