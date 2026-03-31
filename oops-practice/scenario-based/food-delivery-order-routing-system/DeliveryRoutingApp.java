import java.util.Scanner;

public class DeliveryRoutingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DeliveryService service = new DeliveryService();

        service.addAgent(new Agent(1, "Rahul", "Noida"));
        service.addAgent(new Agent(2, "Aman", "Delhi"));
        service.addAgent(new Agent(3, "Priya", "Noida"));

        while (true) {
            System.out.println("\n1. Place Order");
            System.out.println("2. Assign Order");
            System.out.println("3. Cancel Order");
            System.out.println("4. View Active Deliveries");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Order ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Location: ");
                    String location = sc.nextLine();

                    service.placeOrder(new Order(id, name, location));
                    System.out.println("Order placed successfully.");
                    break;

                case 2:
                    try {
                        service.assignOrder();
                    } catch (NoAgentAvailableException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter Order ID to cancel: ");
                    int cancelId = sc.nextInt();
                    service.cancelOrder(cancelId);
                    break;

                case 4:
                    service.viewActiveDeliveries();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
