import java.util.*;

public class LexicalTwist {

    private static boolean isInvalidWord(String s) {
        return s == null || s.trim().contains(" ");
    }

    private static boolean isVowel(char c) {
        return "AEIOU".indexOf(c) != -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word");
        String first = sc.nextLine();

        if (isInvalidWord(first)) {
            System.out.println(first + " is an invalid word");
          
        }

        System.out.println("Enter the second word");
        String second = sc.nextLine();

        if (isInvalidWord(second)) {
            System.out.println(second + " is an invalid word");
            
        }

        // Check if second is reverse of first (case-insensitive)
        String reversedFirst = new StringBuilder(first).reverse().toString();

        if (reversedFirst.equalsIgnoreCase(second)) {

            // Step 1 & 2: reverse + lowercase
            String result = reversedFirst.toLowerCase();

            // Step 3: replace vowels with '@'
            StringBuilder transformed = new StringBuilder();
            for (char c : result.toCharArray()) {
                if ("aeiou".indexOf(c) != -1) {
                    transformed.append('@');
                } else {
                    transformed.append(c);
                }
            }

            System.out.println(transformed.toString());

        } else {

            // Combine and uppercase
            String combined = (first + second).toUpperCase();

            int vowelCount = 0;
            int consonantCount = 0;

            for (char c : combined.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    if (isVowel(c)) vowelCount++;
                    else consonantCount++;
                }
            }

            if (vowelCount == consonantCount) {
                System.out.println("Vowels and consonants are equal");
            }

            boolean needVowels = vowelCount > consonantCount;
            Set<Character> collected = new LinkedHashSet<>();

            for (char c : combined.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    if (needVowels && isVowel(c)) {
                        collected.add(c);
                    } else if (!needVowels && !isVowel(c)) {
                        collected.add(c);
                    }
                }

                if (collected.size() == 2) break;
            }

            StringBuilder output = new StringBuilder();
            for (char c : collected) {
                output.append(c);
            }

            System.out.println(output.toString());
        }

        sc.close();
    }
}
