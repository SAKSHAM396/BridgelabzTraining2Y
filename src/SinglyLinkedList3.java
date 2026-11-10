
import java.util.Scanner;

class User {
    int id, age;
    String name;
    User next;
    int[] friends = new int[100];
    int count = 0;

    User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class SinglyLinkedList3 {
    static User head = null;
    static Scanner sc = new Scanner(System.in);

    static User find(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.id == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    static void addUser() {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (find(id) != null) {
            System.out.println("User already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        User u = new User(id, name, age);

        if (head == null)
            head = u;
        else {
            User temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = u;
        }

        System.out.println("User added.");
    }

    static void addFriend() {
        System.out.print("Enter First User ID: ");
        int id1 = sc.nextInt();
        System.out.print("Enter Second User ID: ");
        int id2 = sc.nextInt();

        User u1 = find(id1);
        User u2 = find(id2);

        if (u1 == null || u2 == null || id1 == id2) {
            System.out.println("Invalid users.");
            return;
        }

        for (int i = 0; i < u1.count; i++) {
            if (u1.friends[i] == id2) {
                System.out.println("Already friends.");
                return;
            }
        }

        u1.friends[u1.count++] = id2;
        u2.friends[u2.count++] = id1;

        System.out.println("Friend connection added.");
    }

    static void removeFriend() {
        System.out.print("Enter First User ID: ");
        int id1 = sc.nextInt();
        System.out.print("Enter Second User ID: ");
        int id2 = sc.nextInt();

        User u1 = find(id1);
        User u2 = find(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        for (int i = 0; i < u1.count; i++) {
            if (u1.friends[i] == id2) {
                u1.friends[i] = u1.friends[--u1.count];
                break;
            }
        }

        for (int i = 0; i < u2.count; i++) {
            if (u2.friends[i] == id1) {
                u2.friends[i] = u2.friends[--u2.count];
                break;
            }
        }

        System.out.println("Friend connection removed.");
    }

    static void mutualFriends() {
        System.out.print("Enter First User ID: ");
        int id1 = sc.nextInt();
        System.out.print("Enter Second User ID: ");
        int id2 = sc.nextInt();

        User u1 = find(id1);
        User u2 = find(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Mutual Friends:");
        boolean found = false;

        for (int i = 0; i < u1.count; i++) {
            for (int j = 0; j < u2.count; j++) {
                if (u1.friends[i] == u2.friends[j]) {
                    User f = find(u1.friends[i]);
                    if (f != null) {
                        System.out.println(f.name + " ID: " + f.id);
                        found = true;
                    }
                }
            }
        }

        if (!found)
            System.out.println("No mutual friends.");
    }

    static void displayFriends() {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();

        User u = find(id);

        if (u == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + u.name + ":");

        for (int i = 0; i < u.count; i++) {
            User f = find(u.friends[i]);
            if (f != null)
                System.out.println(f.name + " ID: " + f.id);
        }
    }

    static void searchUser() {
        sc.nextLine();
        System.out.print("Enter Name or User ID: ");
        String s = sc.nextLine();

        User temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(s) ||
                    String.valueOf(temp.id).equals(s)) {
                System.out.println("ID: " + temp.id);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("User not found.");
    }

    static void countFriends() {
        User temp = head;

        while (temp != null) {
            System.out.println(temp.name + " (ID: " +
                    temp.id + ") Friends: " + temp.count);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int ch;

        do {
            System.out.println("\n1. Add User");
            System.out.println("2. Add Friend");
            System.out.println("3. Remove Friend");
            System.out.println("4. Mutual Friends");
            System.out.println("5. Display Friends");
            System.out.println("6. Search User");
            System.out.println("7. Count Friends");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1: addUser(); break;
                case 2: addFriend(); break;
                case 3: removeFriend(); break;
                case 4: mutualFriends(); break;
                case 5: displayFriends(); break;
                case 6: searchUser(); break;
                case 7: countFriends(); break;
                case 8: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }

        } while (ch != 8);

        sc.close();
    }
}
