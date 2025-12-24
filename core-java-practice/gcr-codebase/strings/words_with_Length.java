import java.util.*;

public class words_with_Length {
  static int findLength(String str) {
        int c = 0;
        while (true) {
            try {
                str.charAt(c);
                c++;
            } catch (Exception e) {
                break;
            }
        }
        return c;
    }

    static String[] splitText(String text) {
        return text.split(" ");
    }

    static String[][] wordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(findLength(words[i]));
        }
        return table;
    }

    public static void main(String[] args) {
        //Taking input
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scan.nextLine();

        String[][] table = wordLengthTable(splitText(text));

        
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + Integer.parseInt(table[i][1]));
        }
        scan.close();
    }
}
