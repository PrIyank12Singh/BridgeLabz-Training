import java.util.function.Function;
import java.util.Scanner;

public class StringLengthChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your message:");
        String message = sc.nextLine();

        // Function to get length of the string
        Function<String, Integer> getLength = str -> str.length();

        int length = getLength.apply(message);
        int maxLimit = 20;

        if (length > maxLimit) {
            System.out.println("Message exceeds the limit of " + maxLimit + " characters. Length: " + length);
        } else {
            System.out.println("Message is within limit. Length: " + length);
        }

        sc.close();
    }
}
