import java.util.*;

public class split_without_split {
  static String[] manualSplit(String text) {
        int w = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
                w++;
        }

        int[] spaces = new int[w + 1];
        int idx = 1;
        spaces[0] = -1;
        spaces[w] = text.length();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
                spaces[idx++] = i;
        }

        String[] result = new String[w];
        for (int i = 0; i < w; i++) {
            result[i] = text.substring(spaces[i] + 1, spaces[i + 1]);
        }
        return result;
    }

    static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        
        String text = scan.nextLine();

        String[] manual = manualSplit(text);
        String[] builtIn = text.split(" ");

        System.out.println("Are both equal? " + compareArrays(manual, builtIn));
        scan.close();
    }
}
