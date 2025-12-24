import java.util.*;

public class illegal_argument_exception {
  // Method 1: Generates IllegalArgumentException (no try-catch)
    static void generateException(String str) {
      
        int start = 5;
        int end = 2;

        // Explicitly throwing IllegalArgumentException
        if (start > end) {
            throw new IllegalArgumentException("Start index cannot be greater than end index");
        }

        String result = str.substring(start, end);
        System.out.println(result);
    }

    // Method 2: Handles IllegalArgumentException and RuntimeException
    static void handleException(String str) {
        System.out.println("\nHandling Exception using try-catch...");
        int start = 5;
        int end = 2;

        try {
            if (start > end) {
                throw new IllegalArgumentException("Start index cannot be greater than end index");
            }
            String result = str.substring(start, end);
            System.out.println(result);

        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException Caught: " + e.getMessage());

        } catch (RuntimeException e) {
            System.out.println("RuntimeException Caught: " + e);
        }
    }

    public static void main(String[] args) {
        //Taking input
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a String: ");
        String input = sc.nextLine();

        // First call: generates exception
        try {
            generateException(input);
        } catch (Exception e) {
            System.out.println("Program stopped due to Runtime Exception");
        }

        // Second call: handles exception
        handleException(input);

        sc.close();
    }
}
