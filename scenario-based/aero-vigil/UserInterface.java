import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FlightUtil flightUtil = new FlightUtil();

        System.out.println("Enter flight details:");
        String input = sc.nextLine();  // Format: FL-1234:SpiceJet:250:50000

        try {
            String[] details = input.split(":");
            if (details.length != 4) {
                System.out.println("Invalid input format. Use FlightNumber:FlightName:PassengerCount:CurrentFuelLevel");
                return;
            }

            String flightNumber = details[0];
            String flightName = details[1];
            int passengerCount = Integer.parseInt(details[2]);
            double currentFuelLevel = Double.parseDouble(details[3]);

            // Perform all validations
            flightUtil.validateFlightNumber(flightNumber);
            flightUtil.validateFlightName(flightName);
            flightUtil.validatePassengerCount(passengerCount, flightName);

            // Calculate fuel required
            double fuelRequired = flightUtil.calculateFuelToFillTank(flightName, currentFuelLevel);
            System.out.println("Fuel required to fill the tank: " + fuelRequired + " liters");

        } catch (InvalidFlightException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Passenger count and fuel level must be numeric values");
        }
    }
}
