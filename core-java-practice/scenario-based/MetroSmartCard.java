import java.util.Scanner;

public class MetroSmartCard {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter initial smart card balance: ");
        int balance = input.nextInt();

        while (balance > 0) {

            System.out.print("\nEnter distance in km (-1 to exit): ");
            int distance = input.nextInt();

            // Exit condition
            if (distance == -1) {
                break;
            }

            // Fare calculation using ternary operator
            int fare = (distance <= 5) ? 10 : 20;

            // Check balance
            if (balance >= fare) {
                balance = balance - fare;
                System.out.println("Fare deducted: ₹" + fare);
                System.out.println("Remaining balance: ₹" + balance);
            } else {
                System.out.println("Insufficient balance!");
                break;
            }
        }

        System.out.println("\nThank you for using Delhi Metro");
        input.close();
    }
}
