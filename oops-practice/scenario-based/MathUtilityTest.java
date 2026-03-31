class MathUtility {

    //utility class for factorial 
    static int factorial(int n) {
        if (n < 0) return -1;

        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }


    //utility class for checking whether number is isPrime or not
    static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    //class for GCD
    static int gcd(int a, int b) {
        if (a < 0 || b < 0) return -1;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    //utility class for Fibonacci
    static int fibonacci(int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

public class MathUtilityTest {
    public static void main(String[] args) {

        System.out.println("Factorial of 5: " + MathUtility.factorial(5));
        System.out.println("Factorial of 0: " + MathUtility.factorial(0));
        System.out.println("Factorial of -3: " + MathUtility.factorial(-3));

        System.out.println("Is 7 Prime? " + MathUtility.isPrime(7));
        System.out.println("Is 1 Prime? " + MathUtility.isPrime(1));

        System.out.println("GCD of 12 & 18: " + MathUtility.gcd(12, 18));
        System.out.println("GCD with negative: " + MathUtility.gcd(-5, 10));

        System.out.println("Fibonacci of 6: " + MathUtility.fibonacci(6));
        System.out.println("Fibonacci of 0: " + MathUtility.fibonacci(0));
    }
}
