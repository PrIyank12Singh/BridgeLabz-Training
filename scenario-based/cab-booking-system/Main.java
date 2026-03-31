import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            User user = new User(1, "Rahul");

            Driver d1 = new Driver(101, "Amit");
            Driver d2 = new Driver(102, "Suresh");

            List<Driver> drivers = Arrays.asList(d1, d2);

            RideService rideService = new RideService();

            System.out.print("Enter distance: ");
            double distance = sc.nextDouble();

            System.out.print("Is peak time? (true/false): ");
            boolean isPeak = sc.nextBoolean();

            // CREATE
            Ride ride = rideService.createRide(user, distance);

            Driver assignedDriver = null;
            for (Driver d : drivers) {
                if (d.isAvailable()) {
                    assignedDriver = d;
                    break;
                }
            }

            if (assignedDriver == null) {
                throw new NoDriverAvailableException("No driver available!");
            }

            FareCalculator calculator =
                    isPeak ? new PeakFareCalculator() : new NormalFareCalculator();

            // UPDATE
            rideService.updateRide(ride, assignedDriver, calculator);

            // READ
            System.out.println("\n--- Ride Details ---");
            rideService.getRideById(ride.getRideId()).showRideDetails();

            // READ ALL
            System.out.println("\n--- Ride History ---");
            rideService.showAllRides();

            // DELETE (optional)
            // rideService.deleteRide(ride.getRideId());

            sc.close();

        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
