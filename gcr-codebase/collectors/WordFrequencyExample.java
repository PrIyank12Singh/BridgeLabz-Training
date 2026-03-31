import java.util.*;
import java.util.stream.*;

public class WordFrequencyExample {
    public static void main(String[] args) {
        String paragraph = "Java is fun. Java is powerful. Streams in Java are useful.";

        Map<String, Long> wordFrequency = Arrays.stream(paragraph
                                            .toLowerCase()
                                            .replaceAll("[^a-z\\s]", "")
                                            .split("\\s+"))
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        System.out.println(wordFrequency);
    }
}
