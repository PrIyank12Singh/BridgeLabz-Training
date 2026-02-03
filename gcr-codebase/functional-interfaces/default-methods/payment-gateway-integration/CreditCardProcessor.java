public class CreditCardProcessor implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Credit Card payment processed: ₹" + amount);
    }

    // Optional: override refund for provider-specific logic
    @Override
    public boolean refund(double amount) {
        System.out.println("Credit Card refund processed: ₹" + amount);
        return true;
    }
}
