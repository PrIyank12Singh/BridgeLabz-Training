import java.util.*;

public class find_non_repeating {
  public static char firstNonRepeating(String str) {
        int[] freq = new int[256];
        int len = str.length();

        for (int i = 0; i < len; i++) freq[str.charAt(i)]++;

        for (int i = 0; i < len; i++) {
            if (freq[str.charAt(i)] == 1) return str.charAt(i);
        }
        return '\0'; // return null char if no unique
    }

    public static void main(String[] args) {
        //Taking input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = scan.nextLine();

        char result = firstNonRepeating(text);
        if (result != '\0') System.out.println("First non-repeating character: " + result);
        else System.out.println("No non-repeating character found.");
        scan.close();
    }
}
