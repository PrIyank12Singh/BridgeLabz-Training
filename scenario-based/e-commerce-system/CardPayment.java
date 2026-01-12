public class CardPayment implements Payment {

    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 5000) {
            throw new PaymentFailedException("Card limit exceeded");
        }
        System.out.println("Paid " + amount + " using Card");
    }
}
