import java.util.Scanner;

public class TemperatureConverter {

    static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double temp = input.nextDouble();

        char choice = input.next().charAt(0);

        if (choice == 'C')
            System.out.println("Celsius: " + fahrenheitToCelsius(temp));
        else
            System.out.println("Fahrenheit: " + celsiusToFahrenheit(temp));

        input.close();
    }
}
