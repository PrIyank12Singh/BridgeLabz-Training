import java.util.*;

public class lowerCase_compare {
  static String toLowerManually(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            result = result + ch;
        }
        return result;
    }

    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //Taking input

        System.out.print("Enter text: ");
        String input = scan.nextLine();

        String manualLower = toLowerManually(input);
        String builtInLower = input.toLowerCase();

        boolean result = compareStrings(manualLower, builtInLower);

        System.out.println("Manual Lowercase: " + manualLower);
        System.out.println("Built-in Lowercase: " + builtInLower);
        System.out.println("Are both equal? " + result);

        scan.close();
    }
}
