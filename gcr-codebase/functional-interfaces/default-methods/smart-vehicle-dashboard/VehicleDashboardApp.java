public class VehicleDashboardApp {

    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle eCar = new ElectricCar();

        System.out.println("Regular Car:");
        car.displaySpeed();
        car.displayBatteryPercentage(); // does nothing

        System.out.println("\nElectric Car:");
        eCar.displaySpeed();
        eCar.displayBatteryPercentage(); // shows battery
    }
}
