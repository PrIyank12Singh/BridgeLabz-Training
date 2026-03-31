import java.util.Scanner;
import java.util.regex.Pattern;

public class HexColorValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter hex color code: ");
        String color = sc.nextLine();

        String regex = "^#[0-9A-Fa-f]{6}$";

        if (Pattern.matches(regex, color)) {
            System.out.println("Valid hex color code");
        } else {
            System.out.println("Invalid hex color code");
        }

        sc.close();
    }
}
