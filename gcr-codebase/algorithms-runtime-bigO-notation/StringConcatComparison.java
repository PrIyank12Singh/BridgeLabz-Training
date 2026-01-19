public class StringConcatComparison {

    static void testString(int n) {
        String s = "";
        long start = System.nanoTime();

        for (int i = 0; i < n; i++) {
            s = s + "a";
        }

        long time = System.nanoTime() - start;
        System.out.println("String Time:        " + time / 1_000_000.0 + " ms");
    }

    static void testStringBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();

        for (int i = 0; i < n; i++) {
            sb.append("a");
        }

        long time = System.nanoTime() - start;
        System.out.println("StringBuilder Time:" + time / 1_000_000.0 + " ms");
    }

    static void testStringBuffer(int n) {
        StringBuffer sb = new StringBuffer();
        long start = System.nanoTime();

        for (int i = 0; i < n; i++) {
            sb.append("a");
        }

        long time = System.nanoTime() - start;
        System.out.println("StringBuffer Time: " + time / 1_000_000.0 + " ms");
    }

    static void test(int n) {

        System.out.println("Operations: " + n);

        if (n <= 10_000) {
            testString(n);
        } else {
            System.out.println("String Time: Skipped (too slow)");
        }

        testStringBuilder(n);
        testStringBuffer(n);

        System.out.println("        ");
    }

    public static void main(String[] args) {

        test(1_000);
        test(10_000);
        test(1_000_000);
    }
}
