import java.util.Scanner;

class TicketNode {
    int ticketId;
    String customer, movie, seat, time;
    TicketNode next;

    TicketNode(int ticketId, String customer, String movie, String seat, String time) {
        this.ticketId = ticketId;
        this.customer = customer;
        this.movie = movie;
        this.seat = seat;
        this.time = time;
        this.next = null;
    }
}

class TicketSystem {
    private TicketNode head = null;

    // add ticket
    void addTicket(TicketNode t) {
        if (head == null) {
            head = t;
            t.next = head;
            return;
        }

        TicketNode temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = t;
        t.next = head;
    }

    // remove ticket
    void removeTicket(int id) {
        if (head == null) return;

        TicketNode curr = head, prev = null;

        do {
            if (curr.ticketId == id) {
                if (curr == head) {
                    TicketNode last = head;
                    while (last.next != head)
                        last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                System.out.println("Ticket removed");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Ticket not found");
    }

    // display tickets
    void display() {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        TicketNode temp = head;
        do {
            print(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // search
    void search(String key) {
        if (head == null) return;

        TicketNode temp = head;
        do {
            if (temp.customer.equalsIgnoreCase(key) ||
                temp.movie.equalsIgnoreCase(key))
                print(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Count tickets
    void countTickets() {
        if (head == null) {
            System.out.println("Total tickets = 0");
            return;
        }

        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total tickets = " + count);
    }

    void print(TicketNode t) {
        System.out.println(
            t.ticketId + " | " + t.customer + " | " + t.movie +
            " | " + t.seat + " | " + t.time
        );
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketSystem ts = new TicketSystem();

        while (true) {
            System.out.println("\n1.Book 2.Cancel 3.Display 4.Search 5.Count 6.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    ts.addTicket(new TicketNode(
                        sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next()));
                    break;
                case 2:
                    ts.removeTicket(sc.nextInt());
                    break;
                case 3:
                    ts.display();
                    break;
                case 4:
                    ts.search(sc.next());
                    break;
                case 5:
                    ts.countTickets();
                    break;
                case 6:
                    sc.close();
                    return;
            }
        }
    }
}
