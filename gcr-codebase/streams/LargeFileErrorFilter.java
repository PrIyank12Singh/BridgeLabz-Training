import java.io.*;
import java.nio.charset.StandardCharsets;

public class LargeFileErrorFilter {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java LargeFileErrorFilter <file_path>");
            return;
        }

        String filePath = args[0];

        readAndFilter(filePath);
    }

    public static void readAndFilter(String filePath) {

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8), 8192)) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
