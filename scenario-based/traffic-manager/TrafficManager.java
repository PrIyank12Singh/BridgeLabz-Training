import java.util.Scanner;

public class TrafficManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Roundabout roundabout = new Roundabout();
        VehicleQueue queue = new VehicleQueue(5); // max waiting vehicles = 5

        while (true) {
            System.out.println("\n--- Traffic Manager Menu ---");
            System.out.println("1. Add vehicle to waiting queue");
            System.out.println("2. Move vehicle into roundabout");
            System.out.println("3. Remove vehicle from roundabout");
            System.out.println("4. Print roundabout state");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter vehicle ID: ");
                    int id = sc.nextInt();
                    queue.enqueue(id);
                    break;

                case 2:
                    int vehicle = queue.dequeue();
                    if (vehicle != -1) {
                        roundabout.addVehicle(vehicle);
                    }
                    break;

                case 3:
                    roundabout.removeVehicle();
                    break;

                case 4:
                    roundabout.printRoundabout();
                    break;

                case 5:
                    System.out.println("System stopped.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
