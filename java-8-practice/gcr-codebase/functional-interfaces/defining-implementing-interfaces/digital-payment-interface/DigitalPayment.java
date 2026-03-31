/**
 * Represents a generic digital payment method.
 */
public interface DigitalPayment {

    /**
     * Process payment for the given amount.
     * @param amount the amount to pay
     */
    void pay(double amount);
}
