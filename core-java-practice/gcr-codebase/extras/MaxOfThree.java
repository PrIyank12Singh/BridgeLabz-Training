import java.util.Scanner;

public class MaxOfThree {

    static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        System.out.println("Maximum: " + findMax(a, b, c));

        scan.close();
    }
}
