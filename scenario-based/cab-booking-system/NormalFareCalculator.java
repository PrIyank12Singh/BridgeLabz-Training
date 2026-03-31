public class NormalFareCalculator implements FareCalculator {
    @Override
    public double calculateFare(double distance) {
        return distance * 10; // 10 per km
    }
}
