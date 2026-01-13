import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TicketManager manager = new TicketManager(1000);

        while (true) {
            System.out.println("\n--- EventManager Menu ---");
            System.out.println("1. Add Ticket");
            System.out.println("2. Sort Tickets by Price");
            System.out.println("3. Show Top 50 Cheapest");
            System.out.println("4. Show Top 50 Expensive");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Event Name: ");
                    String event = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    manager.addTicket(new Ticket(id, event, price));
                    break;

                case 2:
                    manager.sortByPrice();
                    System.out.println("Tickets sorted by price using Quick Sort.");
                    break;

                case 3:
                    manager.displayTopCheapest(50);
                    break;

                case 4:
                    manager.displayTopExpensive(50);
                    break;

                case 5:
                    System.out.println("System closed.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
