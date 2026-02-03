import java.util.function.Predicate;
import java.util.Scanner;

public class TemperatureAlertSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter current temperature:");
        double temperature = sc.nextDouble();

        // Threshold set to 38.0°C
        Predicate<Double> isHighTemp = temp -> temp > 38.0;

        if (isHighTemp.test(temperature)) {
            System.out.println("ALERT! Temperature is too high: " + temperature + "°C");
        } else {
            System.out.println("Temperature is normal: " + temperature + "°C");
        }

        sc.close();
    }
}
