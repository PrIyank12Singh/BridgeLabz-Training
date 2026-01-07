public class Ride {
    private int rideId;
    private User user;
    private Driver driver;
    private double distance;
    private double fare;

    public Ride(int rideId, User user, double distance) {
        this.rideId = rideId;
        this.user = user;
        this.distance = distance;
    }

    public int getRideId() {
        return rideId;
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
        driver.assignRide();
    }

    public void calculateFare(FareCalculator calculator) {
        this.fare = calculator.calculateFare(distance);
    }

    public void showRideDetails() {
        System.out.println("Ride ID: " + rideId);
        System.out.println("User: " + user.getName());
        System.out.println("Driver: " + driver.getName());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Fare: INR " + fare);
    }
}
