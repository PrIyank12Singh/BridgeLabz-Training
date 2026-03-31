class SmartAC implements SmartDevice {

    @Override
    public void turnOn() {
        System.out.println("Smart AC is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart AC is OFF");
    }
}