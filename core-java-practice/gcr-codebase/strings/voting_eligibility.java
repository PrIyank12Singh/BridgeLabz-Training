import java.util.*;

public class voting_eligibility {
  static int[] generateAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = 10 + (int)(Math.random() * 91); // random 10-100
        }
        return ages;
    }

    static String[][] checkVoting(int[] ages) {
        String[][] table = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            table[i][0] = String.valueOf(ages[i]);
            table[i][1] = (ages[i] >= 18) ? "true" : "false";
        }
        return table;
    }

    static void displayTable(String[][] table) {
        System.out.println("Age\tCan Vote");
        for (int i = 0; i < table.length; i++)
            System.out.println(table[i][0] + "\t" + table[i][1]);
    }

    public static void main(String[] args) {
        //Taking input
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scan.nextInt();

        int[] ages = generateAges(n);
        String[][] result = checkVoting(ages);

        displayTable(result);
        scan.close();
    }
}
