import java.io.*;

public class ImageByteArrayCopy {

    public static void main(String[] args) {

        String sourceImage = "input.jpg";     // put your image here
        String outputImage = "output.jpg";

        try {
            byte[] imageBytes = imageToByteArray(sourceImage);
            writeByteArrayToImage(imageBytes, outputImage);

            boolean same = compareFiles(sourceImage, outputImage);

            if (same) {
                System.out.println("Success: Images are identical.");
            } else {
                System.out.println("Warning: Images are different.");
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    // Convert image file to byte array
    public static byte[] imageToByteArray(String filePath) throws IOException {

        try (FileInputStream fis = new FileInputStream(filePath);
              ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray();
        }
    }

    // Write byte array back to image file
    public static void writeByteArrayToImage(byte[] data, String outputPath) throws IOException {

        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
              FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Compare two files byte by byte
    public static boolean compareFiles(String file1, String file2) throws IOException {

        try (FileInputStream fis1 = new FileInputStream(file1);
              FileInputStream fis2 = new FileInputStream(file2)) {

            int b1, b2;

            while (true) {
                b1 = fis1.read();
                b2 = fis2.read();

                if (b1 != b2) return false;
                if (b1 == -1) return true; // both ended
            }
        }
    }
}
