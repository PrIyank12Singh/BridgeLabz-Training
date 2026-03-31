import java.util.*;

public class shortest_length {
  static int length(String str) {
        int ch = 0;
        while (true) {
            try { str.charAt(ch++); }
            catch (Exception e) { break; }
        }
        return ch;
    }

    static String[] split(String text) {
        return text.split(" ");
    }

    static int[] shortestLongest(String[] words) {
        int min = length(words[0]);
        int max = min;

        for (int i = 1; i < words.length; i++) {
            int l = length(words[i]);
            if (l < min) min = l;
            if (l > max) max = l;
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        //Taking input
        Scanner scan = new Scanner(System.in);

        
        String text = scan.nextLine();

        int[] result = shortestLongest(split(text));
        System.out.println("Shortest Length: " + result[0]);
        System.out.println("Longest Length: " + result[1]);

        scan.close();
    }
}
