import java.util.*;

public class FlipKeyLogical {

    public static String CleanseAndInvert(String input) {

        // null or length < 6
        if (input == null || input.length() < 6) {
            return "";
        }

        // only alphabets allowed (no space, digit, special char)
        if (!input.matches("[A-Za-z]+")) {
            return "";
        }

        // Convert to lowercase
        input = input.toLowerCase();

        // Remove characters with even ASCII values
        StringBuilder filtered = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (ch % 2 != 0) {   // keep only odd ASCII
                filtered.append(ch);
            }
        }

        // Reverse
        filtered.reverse();

        // Uppercase characters at even positions (0-based)
        for (int i = 0; i < filtered.length(); i++) {
            if (i % 2 == 0) {
                filtered.setCharAt(i, Character.toUpperCase(filtered.charAt(i)));
            }
        }

        return filtered.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word");
        String input = sc.nextLine();

        String result = CleanseAndInvert(input);

        if (result.isEmpty()) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is - " + result);
        }

        sc.close();
    }
}
