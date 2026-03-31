import java.io.*;
import java.nio.charset.Charset;
public class ReadFileUsingInputStreamReader {

    public static void main(String[] args) {

        String filePath = "input.txt";   // change to your file path
        String charsetName = "UTF-8";    // encoding

        try (
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName(charsetName));
            BufferedReader br = new BufferedReader(isr)
        ) {

            String line;

            // read file line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
