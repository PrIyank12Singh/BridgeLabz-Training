import java.util.*;

public class RideService {

    private Map<Integer, Ride> rideDB = new HashMap<>();
    private int rideCounter = 1;

    // CREATE
    public Ride createRide(User user, double distance) {
        Ride ride = new Ride(rideCounter++, user, distance);
        rideDB.put(ride.getRideId(), ride);
        return ride;
    }

    // READ
    public Ride getRideById(int rideId) {
        return rideDB.get(rideId);
    }

    // UPDATE
    public void updateRide(Ride ride, Driver driver, FareCalculator calculator) {
        ride.assignDriver(driver);
        ride.calculateFare(calculator);
    }

    // DELETE
    public void deleteRide(int rideId) {
        rideDB.remove(rideId);
        System.out.println("Ride " + rideId + " deleted.");
    }

    // READ ALL
    public void showAllRides() {
        for (Ride ride : rideDB.values()) {
            ride.showRideDetails();
            System.out.println( );
        }
    }
}
