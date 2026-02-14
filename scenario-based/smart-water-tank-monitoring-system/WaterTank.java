public class WaterTank {

    private String tankId;
    private double capacity;
    private double currentLevel;

    public WaterTank(String tankId, double capacity, double currentLevel)
            throws InvalidWaterLevelException {

        if (currentLevel > capacity) {
            throw new InvalidWaterLevelException(
                    "Water level cannot exceed capacity for Tank: " + tankId);
        }

        this.tankId = tankId;
        this.capacity = capacity;
        this.currentLevel = currentLevel;
    }

    public String getTankId() {
        return tankId;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getCurrentLevel() {
        return currentLevel;
    }

    public double getUsagePercentage() {
        return (currentLevel / capacity) * 100;
    }

    public boolean isBelowThreshold() {
        return getUsagePercentage() < 20;
    }
}
