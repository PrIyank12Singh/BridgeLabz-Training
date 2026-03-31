import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateCreditCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter credit card number: ");
        String card = sc.nextLine();

        if (Pattern.matches("^4\\d{15}$", card)) {
            System.out.println("Valid Visa card");
        } else if (Pattern.matches("^5\\d{15}$", card)) {
            System.out.println("Valid MasterCard");
        } else {
            System.out.println("Invalid card number");
        }

        sc.close();
    }
}
