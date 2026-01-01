class Vehicle {

    //static variable
    static double registrationFee = 150.0;

    // instance variables
    String ownerName;
    String vehicleType;

    // final variable
    final String registrationNumber;

    // constructor using this
    Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // static method
    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    // display details using instanceof
    void displayDetails(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle vehicle = (Vehicle) obj;
            System.out.println("Owner Name: " + vehicle.ownerName);
            System.out.println("Vehicle Type: " + vehicle.vehicleType);
            System.out.println("Registration Number: " + vehicle.registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
            System.out.println();
        }
    }
}

public class VehicleApp {
    public static void main(String[] args) {

        Vehicle vehicle1 = new Vehicle("ABC123", "Honest raj", "Sedan");
        Vehicle vehicle2 = new Vehicle("XYZ789", "Price danish", "SUV");

        vehicle1.displayDetails(vehicle1);
        vehicle2.displayDetails(vehicle2);
    }
}
