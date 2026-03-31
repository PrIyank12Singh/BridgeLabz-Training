import java.util.Scanner;

public class VehicleRentalApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Vehicle: 1.Car 2.Bike 3.Bus");
        int choice = sc.nextInt();

        RentableVehicle vehicle;

        switch (choice) {
            case 1:
                vehicle = new RentalCar();
                break;
            case 2:
                vehicle = new RentalBike();
                break;
            case 3:
                vehicle = new RentalBus();
                break;
            default:
                System.out.println("Invalid choice");
                sc.close();
                return;
        }

        vehicle.rent();
        vehicle.returnVehicle();

        sc.close();
    }
}
