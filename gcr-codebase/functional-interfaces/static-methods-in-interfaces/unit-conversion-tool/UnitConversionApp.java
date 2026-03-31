import java.util.Scanner;

public class UnitConversionApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter distance in km:");
        double km = sc.nextDouble();
        System.out.println(km + " km = " + UnitConverter.kmToMiles(km) + " miles");

        System.out.println("Enter weight in kg:");
        double kg = sc.nextDouble();
        System.out.println(kg + " kg = " + UnitConverter.kgToLbs(kg) + " lbs");

        sc.close();
    }
}
