import java.io.*;

public class ReadFileLineByLine {

    public static void main(String[] args) {

        String filePath = "input.txt"; // change to your file path

        // try-with-resources ensures the file is closed automatically
        try (FileReader fileReader = new FileReader(filePath);
              BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;

            // read each line until end of file
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
