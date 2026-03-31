public interface Vehicle {

    void displaySpeed();

    // Default method for electric vehicles
    default void displayBatteryPercentage() {
        // Default: not applicable for non-electric vehicles
    }
}
