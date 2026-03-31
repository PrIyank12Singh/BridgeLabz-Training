public class NormalPricing implements PricingStrategy {

    private static final double RATE_PER_UNIT = 10.0;

    @Override
    public double calculatePrice(double units) {
        return units * RATE_PER_UNIT;
    }
}
