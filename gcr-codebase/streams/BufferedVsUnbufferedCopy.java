import java.io.*;

public class BufferedVsUnbufferedCopy {

    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {

        String sourceFile = "largefile.dat";   // change path if needed
        String normalCopyFile = "normal_copy.dat";
        String bufferedCopyFile = "buffered_copy.dat";

        long normalTime = copyUsingNormalStreams(sourceFile, normalCopyFile);
        long bufferedTime = copyUsingBufferedStreams(sourceFile, bufferedCopyFile);

        System.out.println("\n--- Performance Comparison ---");
        System.out.println("Normal Streams Time   : " + normalTime + " ms");
        System.out.println("Buffered Streams Time : " + bufferedTime + " ms");

        if (bufferedTime < normalTime) {
            System.out.println("Buffered streams are faster.");
        } else {
            System.out.println("Normal streams are faster (rare case).");
        }
    }

    // Unbuffered copy
    public static long copyUsingNormalStreams(String source, String destination) {

        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(source);
              FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error during normal stream copy: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000; // convert to ms
    }

    // Buffered copy
    public static long copyUsingBufferedStreams(String source, String destination) {

        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
              BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error during buffered stream copy: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000; // convert to ms
    }
}
