import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java WordFrequencyCounter <file_path>");
            return;
        }

        String filePath = args[0];

        countWordsAndShowTop5(filePath);
    }

    public static void countWordsAndShowTop5(String filePath) {

        HashMap<String, Integer> wordCountMap = new HashMap<>();

        // Read file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {

                // Remove punctuation and convert to lowercase
                line = line.toLowerCase().replaceAll("[^a-z0-9 ]", " ");

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.isEmpty()) continue;

                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            return;

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort words by frequency
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());

        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Display top 5
        System.out.println("\nTop 5 most frequent words:\n");

        int limit = Math.min(5, list.size());

        for (int i = 0; i < limit; i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
