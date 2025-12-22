import java.util.*;

public class length_without_length {
  static int findLength(String text) {
        int cout = 0;

        while (true) {
            try {
                text.charAt(cout);
                cout++;
            } catch (RuntimeException e) {
                break;
            }
        }
        return cout;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        
        String input = scan.next();

        int manualLength = findLength(input);
        int builtInLength = input.length();

        System.out.println("Length without length(): " + manualLength);
        System.out.println("Length using length(): " + builtInLength);

        scan.close();
    }
}
