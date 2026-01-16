import java.io.*;
import java.nio.charset.Charset;

class PerformanceComparison {

    private static final int CONCAT_ITERATIONS = 1_000_000;
    private static final String FILE_PATH = "largefile.txt"; 

    public static void main(String[] args) {

        System.out.println("    StringBuilder vs StringBuffer Concatenation   ");
        compareStringBuilderAndBuffer();

        System.out.println("\n   FileReader vs InputStreamReader Word Count   ");
        compareFileReaders();
    }

    //  StringBuilder vs StringBuffer
    private static void compareStringBuilderAndBuffer() {

        String str = "hello";

        // StringBuilder
        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CONCAT_ITERATIONS; i++) {
            sb.append(str);
        }
        long endBuilder = System.nanoTime();
        System.out.println("StringBuilder time: " + (endBuilder - startBuilder) / 1_000_000.0 + " ms");

        // StringBuffer
        long startBuffer = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < CONCAT_ITERATIONS; i++) {
            sbuf.append(str);
        }
        long endBuffer = System.nanoTime();
        System.out.println("StringBuffer time:  " + (endBuffer - startBuffer) / 1_000_000.0 + " ms");
    }

    //  FileReader vs InputStreamReader
    private static void compareFileReaders() {

        try {
            // FileReader
            long startFileReader = System.nanoTime();
            int fileReaderWordCount = countWordsUsingFileReader(FILE_PATH);
            long endFileReader = System.nanoTime();
            System.out.println("FileReader word count: " + fileReaderWordCount);
            System.out.println("FileReader time: " + (endFileReader - startFileReader) / 1_000_000.0 + " ms");

            // InputStreamReader 
            long startInputStreamReader = System.nanoTime();
            int inputStreamReaderWordCount = countWordsUsingInputStreamReader(FILE_PATH, "UTF-8");
            long endInputStreamReader = System.nanoTime();
            System.out.println("InputStreamReader word count: " + inputStreamReaderWordCount);
            System.out.println("InputStreamReader time: " + (endInputStreamReader - startInputStreamReader) / 1_000_000.0 + " ms");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static int countWordsUsingFileReader(String filePath) throws IOException {
        int wordCount = 0;
        try (FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); // split on whitespace
                wordCount += words.length;
            }
        }
        return wordCount;
    }

    private static int countWordsUsingInputStreamReader(String filePath, String charsetName) throws IOException {
        int wordCount = 0;
        try (FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName(charsetName));
            BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); // split on whitespace
                wordCount += words.length;
            }
        }
        return wordCount;
    }
}
