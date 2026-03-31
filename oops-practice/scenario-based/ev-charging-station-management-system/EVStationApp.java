import java.util.Scanner;

public class EVStationApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of charging slots: ");
        int totalSlots = sc.nextInt();

        System.out.println("Select Pricing: 1. Normal  2. Peak");
        int choice = sc.nextInt();

        PricingStrategy strategy;

        if (choice == 2) {
            strategy = new PeakHourPricing();
        } else {
            strategy = new NormalPricing();
        }

        ChargingStationManager manager =
                new ChargingStationManager(totalSlots, strategy);

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter vehicle number:");
            String vehicleNo = sc.nextLine();

            System.out.println("Enter units consumed:");
            double units = sc.nextDouble();
            sc.nextLine();

            VehicleUnit vehicle = new VehicleUnit(vehicleNo, units);

            try {
                manager.assignSlot(vehicle);
            } catch (NoChargingSlotAvailableException e) {
                System.out.println(e.getMessage());
            }
        }

        manager.showWaitingQueue();
        sc.close();
    }
}
