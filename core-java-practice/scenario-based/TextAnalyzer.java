class TextAnalyzer {

    static void analyzeText(String paragraph, String oldWord, String newWord) {

        // edge case handling
        if (paragraph == null || paragraph.trim().isEmpty()) {
            System.out.println("Paragraph is empty");
            return;
        }

        // remove extra spaces
        paragraph = paragraph.trim().replaceAll("\\s+", " ");

        // split into words
        String[] words = paragraph.split(" ");

        // count words
        System.out.println("Word Count: " + words.length);

        // find longest word
        String longestWord = words[0];
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("Longest Word: " + longestWord);

        // replace word
        String replacedParagraph =
                paragraph.replaceAll("(?i)\\b" + oldWord + "\\b", newWord);

        System.out.println("Updated Paragraph:");
        System.out.println(replacedParagraph);
    }

    public static void main(String[] args) {

        String paragraph = "Java is powerful and java is popular";

        analyzeText(paragraph, "java", "Python");
    }
}
