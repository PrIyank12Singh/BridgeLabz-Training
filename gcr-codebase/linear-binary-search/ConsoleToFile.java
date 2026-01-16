import java.io.*;

public class ConsoleToFile {

    public static void main(String[] args) {

        String filePath = "output.txt"; // file to write into

        try (
            // read from console
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            // write to file
            FileWriter fw = new FileWriter(filePath, true) // true = append mode
        ) {

            System.out.println("Enter text (type 'exit' to stop):");

            String line;

            while (true) {
                line = br.readLine();

                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                fw.write(line);
                fw.write(System.lineSeparator()); // new line in file
                fw.flush(); // ensure data is written immediately
            }

            System.out.println("Input successfully written to file: " + filePath);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
