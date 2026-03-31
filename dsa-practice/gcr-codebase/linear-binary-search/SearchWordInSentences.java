public class SearchWordInSentences {

    public static void main(String[] args) {

        String[] sentences = {
            "Java is fun",
            "I love coding",
            "Linear search is simple",
            "Hello world"
        };

        String word = "Linear";

        String result = findSentenceContainingWord(sentences, word);

        System.out.println(result);
    }

    public static String findSentenceContainingWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence; // return first sentence containing the word
            }
        }
        return "Not Found"; // if no sentence contains the word
    }
}
