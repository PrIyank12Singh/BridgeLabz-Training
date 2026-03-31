import java.util.Scanner;

public class ReplaceWordInSentence {

    // Method for replacing a word
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String result = "";
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(oldWord)) {
                result = result + newWord;
            } else {
                result = result + words[i];
            }

            if (i < words.length - 1) {
                result = result + " ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        String sentence = sc.nextLine();
        String oldWord = sc.next();

        String newWord = sc.next();

        // Method call
        String updatedSentence = replaceWord(sentence, oldWord, newWord);

        System.out.println("Updated Sentence: " + updatedSentence);

        sc.close();
    }
}
