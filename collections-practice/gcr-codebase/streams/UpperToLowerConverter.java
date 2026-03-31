import java.io.*;
import java.nio.charset.StandardCharsets;

public class UpperToLowerConverter {

    public static void main(String[] args) {

        String sourceFile = "input.txt";
        String destinationFile = "output.txt";

        convertToLowerCase(sourceFile, destinationFile);
    }

    public static void convertToLowerCase(String source, String destination) {

        try (
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(source), StandardCharsets.UTF_8));

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(destination), StandardCharsets.UTF_8))
        ) {

            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(Character.toLowerCase((char) ch));
            }

            System.out.println("File converted successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + source);

        } catch (IOException e) {
            System.out.println("I/O error occurred: " + e.getMessage());
        }
    }
}
