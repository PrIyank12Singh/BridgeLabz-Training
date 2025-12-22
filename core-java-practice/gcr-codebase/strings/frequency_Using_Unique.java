import java.util.*;

public class frequency_Using_Unique {
  public static char[] uniqueCharacters(String str) {
        int len = str.length();
        char[] unique = new char[len];
        int k = 0;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == c) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) unique[k++] = c;
        }
        char[] result = new char[k];
        System.arraycopy(unique, 0, result, 0, k);
        return result;
    }

    public static String[][] charFrequencyUsingUnique(String str) {
        char[] unique = uniqueCharacters(str);
        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == unique[i]) count++;
            }
            result[i][0] = Character.toString(unique[i]);
            result[i][1] = Integer.toString(count);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = scan.nextLine();

        String[][] freq = charFrequencyUsingUnique(text);
        System.out.println("Character | Frequency");
        System.out.println("--------------------");
        for (String[] pair : freq) {
            System.out.printf("%-9s | %s\n", pair[0], pair[1]);
        }
        scan.close();
    }
}
