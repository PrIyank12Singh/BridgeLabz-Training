import java.util.Scanner;

public class PasswordValidatorApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a password to validate:");
        String password = sc.nextLine();

        if (SecurityUtils.isStrongPassword(password)) {
            System.out.println("Password is strong ");
        } else {
            System.out.println("Password is weak ");
        }

        sc.close();
    }
}
