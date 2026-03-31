public class VehicleUnit {

    private String vehicleNumber;
    private double unitsConsumed;

    public VehicleUnit(String vehicleNumber, double unitsConsumed) {
        this.vehicleNumber = vehicleNumber;
        this.unitsConsumed = unitsConsumed;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public double getUnitsConsumed() {
        return unitsConsumed;
    }
}
