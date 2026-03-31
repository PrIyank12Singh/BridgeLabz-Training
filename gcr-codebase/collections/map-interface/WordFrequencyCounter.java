import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        String filename = "input.txt";  // your text file

        Map<String, Integer> freqMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Remove punctuation and convert to lowercase
                line = line.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.isEmpty()) continue;
                    freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(freqMap);
    }
}
