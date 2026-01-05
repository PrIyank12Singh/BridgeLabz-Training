import java.util.*;

// interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// abstract Class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    // encapsulated insurance policy number
    private String insurancePolicyNumber;

    // constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate, String policyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = policyNumber;
    }

    // getters (Encapsulation)
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    // No direct getter for policy number (sensitive data)
    protected String getInsurancePolicyNumberMasked() {
        return "****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }

    // abstract method
    public abstract double calculateRentalCost(int days);
}

// car
class Car extends Vehicle implements Insurable {

    public Car(String number, double rate, String policy) {
        super(number, "Car", rate, policy);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.10;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance (10%) Policy: " + getInsurancePolicyNumberMasked();
    }
}

// bike
class Bike extends Vehicle implements Insurable {

    public Bike(String number, double rate, String policy) {
        super(number, "Bike", rate, policy);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days * 0.9; // 10% discount
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.05;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance (5%) Policy: " + getInsurancePolicyNumberMasked();
    }
}

// truck
class Truck extends Vehicle implements Insurable {

    public Truck(String number, double rate, String policy) {
        super(number, "Truck", rate, policy);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days * 1.2; // heavy vehicle charge
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.15;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance (15%) Policy: " + getInsurancePolicyNumberMasked();
    }
}

// main Class
public class VehicleRentalSystem {

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("CAR101", 2500, "POL123456"));
        vehicles.add(new Bike("BIKE202",1000, "POL654321"));
        vehicles.add(new Truck("TRK303", 6000, "POL999888"));

        // polymorphism in action
        for (Vehicle v : vehicles) {
            double rent = v.calculateRentalCost(5);

            double insurance = 0;
            if (v instanceof Insurable) {
                insurance = ((Insurable) v).calculateInsurance();
                System.out.println(((Insurable) v).getInsuranceDetails());
            }

            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Rental Cost: " + rent);
            System.out.println("Insurance Cost: " + insurance);
            System.out.println( );
        }
    }
}
