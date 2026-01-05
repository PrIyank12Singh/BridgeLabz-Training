import java.util.*;

// interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// abstract Class
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    protected double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Encapsulation using getters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    // abstract method
    public abstract double calculateFare(double distance);

    // concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
    }
}
class Car extends Vehicle implements GPS {
    private String location = "Unknown";

    public Car(String id, String driver) {
        super(id, driver, 15);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}
class Bike extends Vehicle implements GPS {
    private String location = "Unknown";

    public Bike(String id, String driver) {
        super(id, driver, 8);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}
class Auto extends Vehicle implements GPS {
    private String location = "Unknown";

    public Auto(String id, String driver) {
        super(id, driver, 10);
    }

    @Override
    public double calculateFare(double distance) {
        return (distance * ratePerKm) + 20; // base charge
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// main class
public class RideHailingApp {

    // polymorphic fare calculation
    public static void calculateRideFare(List<Vehicle> vehicles, double distance) {

        for (Vehicle v : vehicles) {
            v.getVehicleDetails();
            System.out.println("Fare: INR " + v.calculateFare(distance));
            System.out.println();
        }
    }

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("CAR01", "Deepak"));
        vehicles.add(new Bike("BIKE02", "Devarshi"));
        vehicles.add(new Auto("AUTO03", "Ansh"));

        calculateRideFare(vehicles, 10);
    }
}
