abstract class Device {

    private String deviceId;
    private boolean status;

    public Device(String deviceId, boolean status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // reusable
    protected void displayBasicStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + (status ? "ON" : "OFF"));
    }

    // must be implemented by subclasses
    public abstract void displayStatus();
}

// thermostat is a  Device
class Thermostat extends Device {

    private double temperatureSetting;

    public Thermostat(String deviceId, boolean status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        displayBasicStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + " degree celsius");
        System.out.println("Device Type: Thermostat");
    }
}


public class SmartHomeSystem {

    public static void main(String[] args) {

        Device thermostat = new Thermostat("TH-14", true, 22.5);

        thermostat.displayStatus();
    }
}
