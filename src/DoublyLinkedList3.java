
import java.util.Scanner;

class Node {
    String text;
    Node prev, next;

    Node(String text) {
        this.text = text;
    }
}

public class DoublyLinkedList3{
    static Node head, tail, current;
    static int size = 0;
    static final int LIMIT = 10;
    static Scanner sc = new Scanner(System.in);

    static void addState() {
        System.out.print("Enter new text: ");
        String text = sc.nextLine();

        Node n = new Node(text);

        if (head == null) {
            head = tail = current = n;
            size = 1;
        } else {
            Node temp = current.next;

            while (temp != null) {
                size--;
                temp = temp.next;
            }

            current.next = null;
            tail = current;

            n.prev = current;
            current.next = n;
            current = tail = n;
            size++;
        }

        if (size > LIMIT) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("Text saved.");
    }

    static void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo.");
        } else {
            current = current.prev;
            System.out.println("Undo successful.");
        }
    }

    static void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo.");
        } else {
            current = current.next;
            System.out.println("Redo successful.");
        }
    }

    static void display() {
        if (current == null) {
            System.out.println("Editor is empty.");
        } else {
            System.out.println("Current Text: " + current.text);
        }
    }

    static void history() {
        Node temp = head;

        System.out.println("Text History:");

        while (temp != null) {
            System.out.println(temp.text);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1. Add New Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Display History");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addState();
                    break;

                case 2:
                    undo();
                    break;

                case 3:
                    redo();
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    history();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
