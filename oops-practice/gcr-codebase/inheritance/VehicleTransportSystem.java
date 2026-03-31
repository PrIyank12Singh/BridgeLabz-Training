abstract class Vehicle {

    private int maxSpeed;
    private String fuelType;

    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    // shared behavior
    protected void displayBasicInfo() {
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }

    // to be implemented by subclasses
    public abstract void displayInfo();
}

// car is a  Vehicle
class Car extends Vehicle {

    private int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo() {
        displayBasicInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
        System.out.println("Vehicle Type: Car");
    }
}

// truck is a  Vehicle
class Truck extends Vehicle {

    private double loadCapacity;

    public Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo() {
        displayBasicInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
        System.out.println("Vehicle Type: Truck");
    }
}

// motorcycle is a  Vehicle
class Motorcycle extends Vehicle {

    private boolean hasCarrier;

    public Motorcycle(int maxSpeed, String fuelType, boolean hasCarrier) {
        super(maxSpeed, fuelType);
        this.hasCarrier = hasCarrier;
    }

    @Override
    public void displayInfo() {
        displayBasicInfo();
        System.out.println("Carrier Available: " + hasCarrier);
        System.out.println("Vehicle Type: Motorcycle");
    }
}

// main class
public class VehicleTransportSystem {

    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car(200, "Petrol", 5);
        vehicles[1] = new Truck(220, "Diesel", 15);
        vehicles[2] = new Motorcycle(240, "Petrol", true);

        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            System.out.println();
        }
    }
}
