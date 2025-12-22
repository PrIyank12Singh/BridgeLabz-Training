import java.util.*;

public class out_of_bound {
  // Method 1: Generates ArrayIndexOutOfBoundsException (no try-catch)
    static void generateException(String[] names) {
        System.out.println("Generating Exception...");
        // Accessing index greater than array length
        System.out.println(names[names.length]); // Runtime Exception
    }

    // Method 2: Handles ArrayIndexOutOfBoundsException and RuntimeException
    static void handleException(String[] names) {
        System.out.println("\nHandling Exception using try-catch...");
        try {
            System.out.println(names[names.length]); // Invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException Caught: " + e);
        } catch (RuntimeException e) {
            System.out.println("RuntimeException Caught: " + e);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Taking array size
        System.out.print("Enter number of names: ");
        int size = scan.nextInt();
        scan.nextLine(); // consume newline

        // Declaring array
        String[] names = new String[size];

        // Taking names input
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scan.nextLine();
        }

        // First call: generates exception
        try {
            generateException(names);
        } catch (Exception e) {
            System.out.println("Program stopped due to Runtime Exception");
        }

        // Second call: handles exception
        handleException(names);

        scan.close();
    }
}
