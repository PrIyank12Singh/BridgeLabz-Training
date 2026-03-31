public class FlightUtil {

    // Validate flight number format: FL-XXXX (1000-9999)
    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
        if (flightNumber.matches("FL-\\d{4}")) {
            int number = Integer.parseInt(flightNumber.substring(3));
            if (number >= 1000 && number <= 9999) {
                return true;
            }
        }
        throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
    }

    // Validate flight name
    public boolean validateFlightName(String flightName) throws InvalidFlightException {
        if (flightName.equals("SpiceJet") || flightName.equals("Vistara") ||
            flightName.equals("IndiGo") || flightName.equals("Air Arabia")) {
            return true;
        }
        throw new InvalidFlightException("The flight name " + flightName + " is invalid");
    }

    // Validate passenger count
    public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {
        int maxCapacity = 0;
        switch (flightName) {
            case "SpiceJet": maxCapacity = 396; break;
            case "Vistara": maxCapacity = 615; break;
            case "IndiGo": maxCapacity = 230; break;
            case "Air Arabia": maxCapacity = 130; break;
        }
        if (passengerCount > 0 && passengerCount <= maxCapacity) {
            return true;
        }
        throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
    }

    // Calculate fuel required to fill tank
    public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException {
        double maxFuel = 0;
        switch (flightName) {
            case "SpiceJet": maxFuel = 200_000; break;
            case "Vistara": maxFuel = 300_000; break;
            case "IndiGo": maxFuel = 250_000; break;
            case "Air Arabia": maxFuel = 150_000; break;
        }
        if (currentFuelLevel < 0 || currentFuelLevel > maxFuel) {
            throw new InvalidFlightException("Invalid fuel level for " + flightName);
        }
        return maxFuel - currentFuelLevel;
    }
}
