/**
 * Represents a generic payment processor.
 */
public interface PaymentProcessor {

    void pay(double amount);

    /**
     * Default refund method to avoid breaking existing implementations.
     * Can be overridden by specific payment providers.
     */
    default boolean refund(double amount) {
        System.out.println("Default refund processed for amount: ₹" + amount);
        return true; // default: always succeed
    }
}
