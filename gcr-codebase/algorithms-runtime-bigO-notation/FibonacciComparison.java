public class FibonacciComparison {

    // Recursive (O(2^N)
    static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative (O(N))
    static int fibonacciIterative(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    static void test(int n) {

        System.out.println("N = " + n);

        // Recursive (skip very large to avoid freezing)
        if (n <= 40) {
            long start = System.nanoTime();
            int r1 = fibonacciRecursive(n);
            long timeRec = System.nanoTime() - start;

            System.out.println("Recursive Result: " + r1);
            System.out.println("Recursive Time:   " + timeRec / 1_000_000.0 + " ms");
        } else {
            System.out.println("Recursive: Skipped (too slow)");
        }

        // Iterative
        long start = System.nanoTime();
        int r2 = fibonacciIterative(n);
        long timeItr = System.nanoTime() - start;

        System.out.println("Iterative Result: " + r2);
        System.out.println("Iterative Time:   " + timeItr / 1_000_000.0 + " ms");

        System.out.println("      ");
    }

    public static void main(String[] args) {
        test(10);
        test(30);
        test(50);
    }
}
