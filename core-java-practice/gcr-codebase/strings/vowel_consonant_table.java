import java.util.*;

public class vowel_consonant_table {
  static String charType(char chAr) {
        if (chAr >= 'A' && chAr <= 'Z') chAr = (char)(chAr + 32);
        if (chAr >= 'a' && chAr <= 'z') {
            if ("aeiou".indexOf(chAr) != -1) return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }

    static String[][] analyzeText(String text) {
        String[][] table = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            table[i][0] = String.valueOf(text.charAt(i));
            table[i][1] = charType(text.charAt(i));
        }
        return table;
    }

    static void displayTable(String[][] table) {
        System.out.println("Char\tType");
        for (int i = 0; i < table.length; i++)
            System.out.println(table[i][0] + "\t" + table[i][1]);
    }

    public static void main(String[] args) {
        //Taking input
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scan.nextLine();
        displayTable(analyzeText(text));
        scan.close();
    }
}
