import java.util.*;

public class number_format_exception {
  // Method 1: Generates NumberFormatException (no try-catch)
    static void generateException(String text) {

        int number = Integer.parseInt(text); // Runtime Exception
        System.out.println("Number is: " + number); // This line will not execute
    }

    // Method 2: Handles NumberFormatException and RuntimeException
    static void handleException(String text) {
        System.out.println("\nHandling Exception using try-catch...");
        try {
            int number = Integer.parseInt(text);
            System.out.println("Number is: " + number);

        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException Caught: " + e);

        } catch (RuntimeException e) {
            System.out.println("RuntimeException Caught: " + e);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Taking user input as String
        System.out.print("Enter a text: ");
        String input = scan.nextLine();

        // First call: generates exception
        try {
            generateException(input);
        } catch (Exception e) {
            System.out.println("Program stopped due to Runtime Exception");
        }

        // Second call: handles exception
        handleException(input);

        scan.close();
    }
}
