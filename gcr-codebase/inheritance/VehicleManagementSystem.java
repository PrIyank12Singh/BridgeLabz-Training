// interface for refuelable 
interface Refuelable {
    void refuel();
}

// superclass for vehicle
abstract class Vehicle {

    private String model;
    private int maxSpeed; // km/h

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    protected void displayVehicleInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }

    // abstract method for Displaying Details 
    public abstract void displayDetails();
}

// electricVehicle is a Vehicle
class ElectricVehicle extends Vehicle {

    private int batteryCapacity; // kWh

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println("Charging the electric vehicle...");
    }

    @Override
    public void displayDetails() {
        displayVehicleInfo();
        System.out.println("Vehicle Type: Electric");
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

// PetrolVehicle is a Vehicle and Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {

    private double fuelTankCapacity; // liters

    public PetrolVehicle(String model, int maxSpeed, double fuelTankCapacity) {
        super(model, maxSpeed);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling the petrol vehicle");
    }

    @Override
    public void displayDetails() {
        displayVehicleInfo();
        System.out.println("Vehicle Type: Petrol");
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " liters");
    }
}

// main class
public class VehicleManagementSystem {

    public static void main(String[] args) {

        Vehicle electricCar = new ElectricVehicle("Bugatti", 250, 75);
        Vehicle petrolCar = new PetrolVehicle("Lamborghini", 220, 50);

        Vehicle[] vehicles = {electricCar, petrolCar};

        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();

            // hybrid behavior demonstration
            if (vehicle instanceof ElectricVehicle ev) {
                ev.charge();
            }

            if (vehicle instanceof Refuelable rv) {
                rv.refuel();
            }

            System.out.println();
        }
    }
}
