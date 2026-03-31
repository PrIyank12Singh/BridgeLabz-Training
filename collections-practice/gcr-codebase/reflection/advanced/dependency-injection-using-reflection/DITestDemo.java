public class DITestDemo {

    public static void main(String[] args) {

        Car car = SimpleDIContainer.createObject(Car.class);
        car.drive();
    }
}
