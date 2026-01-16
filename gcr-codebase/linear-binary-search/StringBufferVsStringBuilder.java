public class StringBufferVsStringBuilder {

    private static final int ITERATIONS = 1_000_000;

    public static void main(String[] args) {

        // test StringBuffer
        long startBuffer = System.nanoTime();

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ITERATIONS; i++) {
            stringBuffer.append("hello");
        }

        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        // test StringBuilder
        long startBuilder = System.nanoTime();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            stringBuilder.append("hello");
        }

        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        // output results
        System.out.println("StringBuffer Time  (nanoseconds): " + bufferTime);
        System.out.println("StringBuilder Time (nanoseconds): " + builderTime);

        // Optional: convert to milliseconds for readability
        System.out.println("\nIn milliseconds:");
        System.out.println("StringBuffer  : " + bufferTime / 1_000_000.0 + " ms");
        System.out.println("StringBuilder : " + builderTime / 1_000_000.0 + " ms");
    }
}
