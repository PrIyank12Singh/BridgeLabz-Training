import java.util.Scanner;

public class SumOfNaturalNumbers {

    public static int findSum(int n) {

        //returning sum of n natural numbers
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

      //taking input
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(findSum(num));
        sc.close();
    }
}
