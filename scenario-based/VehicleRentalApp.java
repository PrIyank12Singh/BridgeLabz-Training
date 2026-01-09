interface IRentable {
    double calculateRent(int days);
}

//Vehicle Class
class Vehicle {
    protected String brand;
    protected double rentPerDay;

    public Vehicle(String brand, double rentPerDay) {
        this.brand = brand;
        this.rentPerDay = rentPerDay;
    }
}

class Bike extends Vehicle implements IRentable {
    public Bike(String brand) {
        super(brand, 500);
    }

    public double calculateRent(int days) {
        return days * rentPerDay;
    }
}

class Car extends Vehicle implements IRentable {
    public Car(String brand) {
        super(brand, 1500);
    }

    public double calculateRent(int days) {
        return days * rentPerDay;
    }
}

class Truck extends Vehicle implements IRentable {
    public Truck(String brand) {
        super(brand, 3000);
    }

    public double calculateRent(int days) {
        return days * rentPerDay;
    }
}

//Main class
public class VehicleRentalApp {
    public static void main(String[] args) {
        IRentable bike = new Bike("Hayabusa");
        IRentable car = new Car("Santro");

        System.out.println("Bike Rent: " + bike.calculateRent(3));
        System.out.println("Car Rent: " + car.calculateRent(2));
    }
}
