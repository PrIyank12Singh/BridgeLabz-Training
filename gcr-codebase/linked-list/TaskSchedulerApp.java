import java.util.Scanner;

class TaskNode {
    int id;
    String name;
    int priority;
    String dueDate;
    TaskNode next;

    TaskNode(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private TaskNode head = null;
    private TaskNode current = null;

    // add at end
    void addTask(TaskNode newNode) {
        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
    }

    // remove by ID
    void removeTask(int id) {
        if (head == null) {
            System.out.println("No tasks");
            return;
        }

        TaskNode curr = head, prev = null;

        do {
            if (curr.id == id) {
                if (curr == head) {
                    TaskNode last = head;
                    while (last.next != head)
                        last = last.next;

                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                System.out.println("Task removed");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Task not found");
    }

    // View current and move next
    void viewNextTask() {
        if (current == null) {
            System.out.println("No tasks");
            return;
        }
        print(current);
        current = current.next;
    }

    // display all
    void displayAll() {
        if (head == null) {
            System.out.println("No tasks");
            return;
        }

        TaskNode temp = head;
        do {
            print(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // search by priority
    void searchByPriority(int p) {
        if (head == null) return;

        TaskNode temp = head;
        do {
            if (temp.priority == p)
                print(temp);
            temp = temp.next;
        } while (temp != head);
    }

    void print(TaskNode t) {
        System.out.println(t.id + " | " + t.name + " | " + t.priority + " | " + t.dueDate);
    }
}

public class TaskSchedulerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();

        while (true) {
            System.out.println("\n1.Add 2.Remove 3.View Next 4.Display 5.Search Priority 6.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    scheduler.addTask(new TaskNode(
                        sc.nextInt(), sc.next(), sc.nextInt(), sc.next()));
                    break;
                case 2:
                    scheduler.removeTask(sc.nextInt());
                    break;
                case 3:
                    scheduler.viewNextTask();
                    break;
                case 4:
                    scheduler.displayAll();
                    break;
                case 5:
                    scheduler.searchByPriority(sc.nextInt());
                    break;
                case 6:
                    sc.close();
                    return;
            }
        }
    }
}
