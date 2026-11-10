
import java.util.Scanner;

class Process {
    int id, burst, remaining, priority;
    int waiting, turnaround;
    Process next;

    Process(int id, int burst, int priority) {
        this.id = id;
        this.burst = burst;
        this.remaining = burst;
        this.priority = priority;
    }
}

public class CircularLinkedList2 {
    static Process head = null, tail = null;
    static Scanner sc = new Scanner(System.in);

    static void addProcess() {
        System.out.print("Process ID: ");
        int id = sc.nextInt();
        System.out.print("Burst Time: ");
        int burst = sc.nextInt();
        System.out.print("Priority: ");
        int priority = sc.nextInt();

        Process p = new Process(id, burst, priority);

        if (head == null) {
            head = tail = p;
            p.next = head;
        } else {
            tail.next = p;
            tail = p;
            tail.next = head;
        }

        System.out.println("Process added.");
    }

    static void removeProcess(int id) {
        if (head == null)
            return;

        Process temp = head, prev = tail;

        do {
            if (temp.id == id) {
                if (temp == head)
                    head = head.next;

                if (temp == tail)
                    tail = prev;

                prev.next = temp.next;

                if (temp == head && temp == tail)
                    head = tail = null;

                if (head == null)
                    tail = null;
                else
                    tail.next = head;

                return;
            }

            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    static void display() {
        if (head == null) {
            System.out.println("No processes remaining.");
            return;
        }

        Process temp = head;

        do {
            System.out.println("ID: " + temp.id +
                    " Burst Remaining: " + temp.remaining +
                    " Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    static void schedule() {
        if (head == null) {
            System.out.println("No processes available.");
            return;
        }

        System.out.print("Enter Time Quantum: ");
        int quantum = sc.nextInt();

        if (quantum <= 0) {
            System.out.println("Invalid time quantum.");
            return;
        }

        int time = 0, totalWaiting = 0, totalTurnaround = 0;
        int completed = 0, count = 0;

        Process temp = head;
        Process start = head;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        int[] ids = new int[count];
        int[] bursts = new int[count];
        int[] completion = new int[count];

        temp = head;
        for (int i = 0; i < count; i++) {
            ids[i] = temp.id;
            bursts[i] = temp.burst;
            temp = temp.next;
        }

        while (head != null) {
            temp = head;

            if (temp.remaining > quantum) {
                time += quantum;
                temp.remaining -= quantum;
            } else {
                time += temp.remaining;
                temp.remaining = 0;

                for (int i = 0; i < count; i++) {
                    if (ids[i] == temp.id) {
                        completion[i] = time;
                        break;
                    }
                }

                removeProcess(temp.id);
                completed++;
            }

            System.out.println("\nAfter execution:");
            display();
        }

        for (int i = 0; i < count; i++) {
            int turnaround = completion[i];
            int waiting = turnaround - bursts[i];

            totalWaiting += waiting;
            totalTurnaround += turnaround;
        }

        System.out.println("\nAverage Waiting Time: " +
                (double) totalWaiting / count);

        System.out.println("Average Turnaround Time: " +
                (double) totalTurnaround / count);
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1. Add Process");
            System.out.println("2. Display Processes");
            System.out.println("3. Round Robin Scheduling");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProcess();
                    break;

                case 2:
                    display();
                    break;

                case 3:
                    schedule();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
