import java.util.*;

public class CensorBadWords {
    public static void main(String[] args) {

        String text = "This is a damn bad example with some stupid words.";

        // List of bad words
        List<String> badWords = Arrays.asList("damn", "stupid");

        // Build regex: \b(damn|stupid)\b
        String regex = "\\b(" + String.join("|", badWords) + ")\\b";

        String censored = text.replaceAll("(?i)" + regex, "****");

        System.out.println("Original: " + text);
        System.out.println("Censored: " + censored);
    }
}
