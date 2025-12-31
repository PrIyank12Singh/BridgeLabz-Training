class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 5000;

    //Parameterized Constructor
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    void displayVehicleDetails() {
        System.out.println(ownerName + " - " + vehicleType);
    }

    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }
}
