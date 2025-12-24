import java.util.Scanner;

public class WindChill {

    public static double calculateWindChill(double temperature, double windSpeed) {
      //Calculating Wind Chill by temperature
      return 35.74 + 0.6215 * temperature +
               (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        //taking input
        Scanner input = new Scanner(System.in);
        double temp = input.nextDouble();
        double windSpeed = input.nextDouble();

        System.out.println(calculateWindChill(temp, windSpeed));
        input.close();
    }
}
