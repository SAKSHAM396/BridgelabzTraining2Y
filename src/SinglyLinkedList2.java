
import java.util.*;

class Item {
    String name;
    int id, quantity;
    double price;
    Item next;

    Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        next = null;
    }
}

public class SinglyLinkedList2 {
    static Scanner sc = new Scanner(System.in);
    static Item head = null;

    static void add(int pos) {
        System.out.print("Enter name, ID, quantity and price: ");
        String name = sc.nextLine();
        int id = sc.nextInt();
        int quantity = sc.nextInt();
        double price = sc.nextDouble();
        sc.nextLine();

        Item n = new Item(name, id, quantity, price);

        if (head == null || pos == 1) {
            n.next = head;
            head = n;
        } else {
            Item t = head;
            for (int i = 1; i < pos - 1 && t.next != null; i++)
                t = t.next;

            n.next = t.next;
            t.next = n;
        }
        System.out.println("Item added.");
    }

    static void remove() {
        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();

        if (head == null) {
            System.out.println("Inventory empty.");
            return;
        }

        if (head.id == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        Item t = head;
        while (t.next != null && t.next.id != id)
            t = t.next;

        if (t.next == null)
            System.out.println("Item not found.");
        else {
            t.next = t.next.next;
            System.out.println("Item removed.");
        }
    }

    static void update() {
        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();

        Item t = head;
        while (t != null && t.id != id)
            t = t.next;

        if (t == null)
            System.out.println("Item not found.");
        else {
            System.out.print("Enter new quantity: ");
            t.quantity = sc.nextInt();
            System.out.println("Quantity updated.");
        }
    }

    static void search() {
        System.out.print("Search by 1.ID  2.Name: ");
        int ch = sc.nextInt();
        sc.nextLine();

        Item t = head;
        boolean found = false;

        if (ch == 1) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            while (t != null) {
                if (t.id == id) {
                    showItem(t);
                    found = true;
                }
                t = t.next;
            }
        } else {
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            while (t != null) {
                if (t.name.equalsIgnoreCase(name)) {
                    showItem(t);
                    found = true;
                }
                t = t.next;
            }
        }

        if (!found)
            System.out.println("Item not found.");
    }

    static void showItem(Item t) {
        System.out.println(t.name + " | ID: " + t.id +
                " | Quantity: " + t.quantity + " | Price: " + t.price);
    }

    static void display() {
        Item t = head;

        if (t == null) {
            System.out.println("Inventory empty.");
            return;
        }

        while (t != null) {
            showItem(t);
            t = t.next;
        }
    }

    static void totalValue() {
        double total = 0;
        Item t = head;

        while (t != null) {
            total += t.price * t.quantity;
            t = t.next;
        }

        System.out.println("Total Inventory Value: " + total);
    }

    static void sort() {
        if (head == null || head.next == null) {
            System.out.println("Not enough items to sort.");
            return;
        }

        System.out.print("Sort by 1.Name  2.Price: ");
        int ch = sc.nextInt();

        System.out.print("Order 1.Ascending  2.Descending: ");
        int order = sc.nextInt();

        for (Item i = head; i.next != null; i = i.next) {
            for (Item j = head; j.next != null; j = j.next) {
                boolean swap = false;

                if (ch == 1) {
                    int cmp = j.name.compareToIgnoreCase(j.next.name);
                    if (order == 1 && cmp > 0) swap = true;
                    if (order == 2 && cmp < 0) swap = true;
                } else {
                    if (order == 1 && j.price > j.next.price) swap = true;
                    if (order == 2 && j.price < j.next.price) swap = true;
                }

                if (swap) {
                    String name = j.name;
                    int id = j.id, quantity = j.quantity;
                    double price = j.price;

                    j.name = j.next.name;
                    j.id = j.next.id;
                    j.quantity = j.next.quantity;
                    j.price = j.next.price;

                    j.next.name = name;
                    j.next.id = id;
                    j.next.quantity = quantity;
                    j.next.price = price;
                }
            }
        }

        System.out.println("Inventory sorted.");
        display();
    }

    public static void main(String[] args) {
        int ch;

        do {
            System.out.println("\n1.Add Beginning");
            System.out.println("2.Add End");
            System.out.println("3.Add Position");
            System.out.println("4.Remove Item");
            System.out.println("5.Update Quantity");
            System.out.println("6.Search Item");
            System.out.println("7.Display Inventory");
            System.out.println("8.Total Inventory Value");
            System.out.println("9.Sort Inventory");
            System.out.println("0.Exit");
            System.out.print("Enter choice: ");

            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1: add(1); break;
                case 2: add(999); break;
                case 3:
                    System.out.print("Enter position: ");
                    add(sc.nextInt());
                    sc.nextLine();
                    break;
                case 4: remove(); break;
                case 5: update(); break;
                case 6: search(); break;
                case 7: display(); break;
                case 8: totalValue(); break;
                case 9: sort(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (ch != 0);
    }
}
