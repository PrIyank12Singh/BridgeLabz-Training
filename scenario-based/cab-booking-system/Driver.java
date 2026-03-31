public class Driver {
    int driverId;
    private String name;
    private boolean available;

    public Driver(int driverId, String name) {
        this.driverId = driverId;
        this.name = name;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void assignRide() {
        available = false;
    }

    public String getName() {
        return name;
    }
}


