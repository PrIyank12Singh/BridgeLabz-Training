public class PaymentGatewayApp {

    public static void main(String[] args) {
        PaymentProcessor processor = new CreditCardProcessor();

        processor.pay(2500);
        processor.refund(500);
    }
}
