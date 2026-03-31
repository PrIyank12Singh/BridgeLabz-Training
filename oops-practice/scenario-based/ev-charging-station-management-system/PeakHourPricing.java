public class PeakHourPricing implements PricingStrategy {

    private static final double RATE_PER_UNIT = 15.0;

    @Override
    public double calculatePrice(double units) {
        return units * RATE_PER_UNIT;
    }
}
