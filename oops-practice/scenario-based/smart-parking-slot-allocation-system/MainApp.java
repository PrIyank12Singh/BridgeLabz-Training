import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ParkingManager manager = new ParkingManager(3);

        try {
            manager.parkVehicle(new Car("CAR101"));
            manager.parkVehicle(new Bike("BIKE201"));
            manager.parkVehicle(new Car("CAR102"));
            manager.parkVehicle(new Bike("BIKE202")); // goes to waiting
        } catch (NoParkingSlotAvailableException e) {
            System.out.println(e.getMessage());
        }

        manager.displayStatus();

        System.out.println("\nReleasing slot 2...");
        manager.releaseSlot(2);

        manager.displayStatus();
    }
}
