public class UPIPayment implements Payment {

    @Override
    public void pay(double amount) throws PaymentFailedException {
        System.out.println("Paid " + amount + " using UPI");
    }
}
