import java.util.*;

public class upperCase_compare {
  static String toUpperManually(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char chAr = text.charAt(i);

            if (chAr >= 'a' && chAr <= 'z') {
                chAr = (char) (chAr - 32);
            }
            result = result + chAr;
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
        //Taking input
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = scan.nextLine();

        String manualUpper = toUpperManually(input);
        String builtInUpper = input.toUpperCase();

        boolean result = compareStrings(manualUpper, builtInUpper);

        System.out.println("Manual Uppercase: " + manualUpper);
        System.out.println("Built-in Uppercase: " + builtInUpper);
        System.out.println("Are both equal? " + result);

        scan.close();
    }
}
