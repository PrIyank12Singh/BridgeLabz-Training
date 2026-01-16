import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordInFile {

    public static void main(String[] args) {

        String filePath = "input.txt";   // change to your file path
        String targetWord = "java";      // word to search

        int count = 0;

        try (FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                // split line into words using spaces and punctuation
                String[] words = line.split("\\W+");

                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }

            System.out.println("The word \"" + targetWord + "\" appears " + count + " times.");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
