import java.util.Scanner;

public class PaymentGatewayApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter amount to pay:");
        double amount = sc.nextDouble();

        System.out.println("Choose Payment Method: 1.UPI 2.Credit Card 3.Wallet");
        int choice = sc.nextInt();

        DigitalPayment payment;

        switch (choice) {
            case 1:
                payment = new UpiPayment();
                break;
            case 2:
                payment = new CreditCardPayment();
                break;
            case 3:
                payment = new WalletPayment();
                break;
            default:
                System.out.println("Invalid choice");
                sc.close();
                return;
        }

        payment.pay(amount);

        sc.close();
    }
}
