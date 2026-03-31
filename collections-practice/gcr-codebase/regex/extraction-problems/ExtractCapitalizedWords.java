import java.util.regex.*;

public class ExtractCapitalizedWords {
    public static void main(String[] args) {

        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        String regex = "\\b[A-Z][a-z]*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Capitalized Words:");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
