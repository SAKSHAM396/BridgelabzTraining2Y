
import java.util.Scanner;

class Ticket {
    int id, seat;
    String customer, movie, time;
    Ticket next;

    Ticket(int id, String customer, String movie, int seat, String time) {
        this.id = id;
        this.customer = customer;
        this.movie = movie;
        this.seat = seat;
        this.time = time;
    }
}

public class CircularLinkedList3 {
    static Ticket head, tail;
    static Scanner sc = new Scanner(System.in);

    static void addTicket() {
        System.out.print("Ticket ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Movie Name: ");
        String movie = sc.nextLine();

        System.out.print("Seat Number: ");
        int seat = sc.nextInt();
        sc.nextLine();

        System.out.print("Booking Time: ");
        String time = sc.nextLine();

        Ticket t = new Ticket(id, name, movie, seat, time);

        if (head == null) {
            head = tail = t;
            tail.next = head;
        } else {
            tail.next = t;
            tail = t;
            tail.next = head;
        }

        System.out.println("Ticket booked successfully.");
    }

    static void removeTicket() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        System.out.print("Enter Ticket ID: ");
        int id = sc.nextInt();

        Ticket temp = head, prev = tail;

        do {
            if (temp.id == id) {
                if (temp == head)
                    head = head.next;

                if (temp == tail)
                    tail = prev;

                if (temp == head && temp == tail)
                    head = tail = null;
                else
                    prev.next = temp.next;

                if (head != null)
                    tail.next = head;

                System.out.println("Ticket removed.");
                return;
            }

            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket not found.");
    }

    static void display() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;

        do {
            System.out.println("\nTicket ID: " + temp.id);
            System.out.println("Customer: " + temp.customer);
            System.out.println("Movie: " + temp.movie);
            System.out.println("Seat: " + temp.seat);
            System.out.println("Booking Time: " + temp.time);

            temp = temp.next;
        } while (temp != head);
    }

    static void search() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        System.out.print("Enter Customer or Movie Name: ");
        String s = sc.nextLine();

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.customer.equalsIgnoreCase(s) ||
                    temp.movie.equalsIgnoreCase(s)) {
                System.out.println("Ticket ID: " + temp.id);
                System.out.println("Customer: " + temp.customer);
                System.out.println("Movie: " + temp.movie);
                System.out.println("Seat: " + temp.seat);
                System.out.println("Booking Time: " + temp.time);
                found = true;
            }

            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("Ticket not found.");
    }

    static int count() {
        int c = 0;

        if (head == null)
            return c;

        Ticket temp = head;

        do {
            c++;
            temp = temp.next;
        } while (temp != head);

        return c;
    }

    public static void main(String[] args) {
        int ch;

        do {
            System.out.println("\n1. Add Ticket");
            System.out.println("2. Remove Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Count Tickets");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1: addTicket(); break;
                case 2: removeTicket(); break;
                case 3: display(); break;
                case 4: search(); break;
                case 5: System.out.println("Total Tickets: " + count()); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }

        } while (ch != 6);

        sc.close();
    }
}
