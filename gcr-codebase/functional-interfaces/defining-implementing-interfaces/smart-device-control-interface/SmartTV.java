class SmartTV implements SmartDevice {

    @Override
    public void turnOn() {
        System.out.println("Smart TV is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart TV is OFF");
    }
}