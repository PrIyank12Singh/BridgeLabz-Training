import java.util.Scanner;

class ProcessNode {
    int pid, burst, remaining;
    ProcessNode next;

    ProcessNode(int pid, int burst) {
        this.pid = pid;
        this.burst = burst;
        this.remaining = burst;
        next = null;
    }
}

class RoundRobinScheduler {
    private ProcessNode head = null;

    // add process
    void addProcess(ProcessNode p) {
        if (head == null) {
            head = p;
            p.next = head;
            return;
        }
        ProcessNode temp = head;
        while (temp.next != head)
            temp = temp.next;
        temp.next = p;
        p.next = head;
    }

    // simulate scheduling
    void schedule(int quantum) {
        if (head == null) return;

        ProcessNode curr = head;
        int time = 0, totalWT = 0, totalTAT = 0, count = countProcesses();

        while (head != null) {
            if (curr.remaining > 0) {
                int exec = Math.min(quantum, curr.remaining);
                curr.remaining -= exec;
                time += exec;

                if (curr.remaining == 0) {
                    totalTAT += time;
                    totalWT += time - curr.burst;
                    removeProcess(curr.pid);
                    curr = head;
                    continue;
                }
            }
            curr = curr.next;
            display();
        }

        System.out.println("Average Waiting Time = " + (double) totalWT / count);
        System.out.println("Average Turnaround Time = " + (double) totalTAT / count);
    }

    // remove process
    void removeProcess(int pid) {
        if (head == null) return;

        ProcessNode curr = head, prev = null;
        do {
            if (curr.pid == pid) {
                if (curr == head && curr.next == head) {
                    head = null;
                    return;
                }
                if (curr == head) {
                    ProcessNode last = head;
                    while (last.next != head)
                        last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        ProcessNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    void display() {
        if (head == null) return;
        ProcessNode temp = head;
        System.out.print("Queue: ");
        do {
            System.out.print("P" + temp.pid + "(" + temp.remaining + ") ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}

public class RoundRobinApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler rr = new RoundRobinScheduler();

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            rr.addProcess(new ProcessNode(sc.nextInt(), sc.nextInt()));
        }

        System.out.print("Enter time quantum: ");
        rr.schedule(sc.nextInt());

        sc.close(); 
    }
}
