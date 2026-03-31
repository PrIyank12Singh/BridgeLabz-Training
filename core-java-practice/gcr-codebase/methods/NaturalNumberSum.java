import java.util.Scanner;

public class NaturalNumberSum {

    public static int recursiveSum(int n) {

      //finding out sum recursively
        if (n == 0)
            return 0;
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
      //calculating formula Sum 
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //taking n as input
        int n = scan.nextInt();

        if (n <= 0) {
            System.out.println("Not a natural number");
        } else {
            int sum1 = recursiveSum(n);
            int sum2 = formulaSum(n);

            System.out.println("Recursive Sum: " + sum1);
            System.out.println("Formula Sum: " + sum2);
        }
        scan.close();
    }
}
