public class RegularPricing implements PricingStrategy {

    public double calculatePrice(double basePrice, int days) {
        return basePrice * days;
    }
}
