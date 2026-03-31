class SmartLight implements SmartDevice {

    @Override
    public void turnOn() {
        System.out.println("Smart Light is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart Light is OFF");
    }
}
