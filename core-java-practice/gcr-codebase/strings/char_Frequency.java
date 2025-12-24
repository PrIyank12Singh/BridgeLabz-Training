import java.util.*;

public class char_Frequency {
  public static String[][] charFrequency(String str) {
        int[] freq = new int[256];
        int len = str.length();

        for (int i = 0; i < len; i++) freq[str.charAt(i)]++;

        int count = 0;
        for (int f : freq) if (f > 0) count++;

        String[][] result = new String[count][2];
        int k = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[k][0] = Character.toString((char)i);
                result[k][1] = Integer.toString(freq[i]);
                k++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //Taking input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = scan.nextLine();

        String[][] freq = charFrequency(text);
        System.out.println("Character | Frequency");
        System.out.println("--------------------");
        for (String[] pair : freq) {
            System.out.printf("%-9s | %s\n", pair[0], pair[1]);
        }
        scan.close();
    }
}
