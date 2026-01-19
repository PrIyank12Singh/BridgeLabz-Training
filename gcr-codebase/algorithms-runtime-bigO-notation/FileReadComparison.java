import java.io.*;

public class FileReadComparison {

    private static final int BUFFER_SIZE = 8192;

    //  FileReader Test 
    static void readUsingFileReader(String path) throws Exception {
        try (FileReader fr = new FileReader(path);
              BufferedReader br = new BufferedReader(fr, BUFFER_SIZE)) {

            while (br.read() != -1) {
                // just reading
            }
        }
    }

    // InputStreamReader Test
    static void readUsingInputStreamReader(String path) throws Exception {
        try (FileInputStream fis = new FileInputStream(path);
              InputStreamReader isr = new InputStreamReader(fis);
              BufferedReader br = new BufferedReader(isr, BUFFER_SIZE)) {

            while (br.read() != -1) {
                // just reading
            }
        }
    }

    static void test(String filePath) throws Exception {

        System.out.println("Testing file: " + filePath);

        // FileReader
        long start = System.nanoTime();
        readUsingFileReader(filePath);
        long fileReaderTime = System.nanoTime() - start;

        // InputStreamReader
        start = System.nanoTime();
        readUsingInputStreamReader(filePath);
        long inputStreamReaderTime = System.nanoTime() - start;

        System.out.println("FileReader Time:        " + fileReaderTime / 1_000_000.0 + " ms");
        System.out.println("InputStreamReader Time:" + inputStreamReaderTime / 1_000_000.0 + " ms");
        System.out.println("            ");
    }

    public static void main(String[] args) throws Exception {

        // Replace with your large file path
        String filePath = "largefile.txt";

        test(filePath);
    }
}
