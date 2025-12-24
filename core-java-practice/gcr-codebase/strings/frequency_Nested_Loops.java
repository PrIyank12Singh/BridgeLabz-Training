import java.util.*;

public class frequency_Nested_Loops {
   public static String[][] charFrequencyNested(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        int[] freq = new int[len];

        for (int i = 0; i < len; i++) {
            if (chars[i] == '0') continue;
            freq[i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }

        int count = 0;
        for (int f : freq) if (f != 0) count++;

        String[][] result = new String[count][2];
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (freq[i] != 0) {
                result[k][0] = Character.toString(chars[i]);
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

        String[][] freq = charFrequencyNested(text);
        System.out.println("Character | Frequency");
        System.out.println("--------------------");
        for (String[] pair : freq) {
            System.out.printf("%-9s | %s\n", pair[0], pair[1]);
        }

        scan.close();
    }
}
