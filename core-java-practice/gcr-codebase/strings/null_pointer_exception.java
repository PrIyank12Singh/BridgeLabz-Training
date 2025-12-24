import java.util.*;

public class null_pointer_exception {
  // Method to generate NullPointerException
    static void generateException() {
        String t = null;   // variable initialized to be null
        System.out.println(t.length()); // calling String method → Exception
    }

    // Method to handle NullPointerException
    static void handleException() {
        String t = null;   // variable initialized to null

        try {
            System.out.println(t.length()); // risky code
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled successfully.");
        }
    }

    public static void main(String[] args) {

        // First call: generates exception
        generateException();

        // Refactored call: handles exception
        handleException();
    }
}
