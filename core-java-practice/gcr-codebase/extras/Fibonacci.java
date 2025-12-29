import java.util.*;

public class Fibonacci {

    static void printFibonacci(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        printFibonacci(n);

        scanner.close();
    }
}
