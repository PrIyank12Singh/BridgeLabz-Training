import java.util.*;

public class string_index_exception {
  // Method 1: Generates StringIndexOutOfBoundsException
    static void generateException(String s) {
        
        // Accessing index beyond string length
        char c = s.charAt(s.length());  // Runtime Exception
        System.out.println(c);               // This line will not execute
    }

    // Method 2: Handles StringIndexOutOfBoundsException
    static void handleException(String s) {
        System.out.println("\nHandling Exception using try-catch...");
        try {
            char c = s.charAt(s.length()); // Invalid index
            System.out.println(c);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception Caught: " + e);
        }
    }

    public static void main(String[] args) {

        //Taking input
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a String: ");
        String input = sc.nextLine();

        // Call method to generate exception
        try {
            generateException(input);
        } catch (Exception e) {
            System.out.println("Program stopped due to Runtime Exception");
        }

        // Call method to handle exception
        handleException(input);

        sc.close();
    }
}
