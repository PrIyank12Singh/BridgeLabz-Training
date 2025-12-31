class Palindrome_Checker {

    // attribute to store text
    String text;

    // method to check palindrome
    boolean isPalindrome() {
        String cleanText = text.replaceAll("\\s+", "").toLowerCase();
        String reversed = "";

        for (int i = cleanText.length() - 1; i >= 0; i--) {
            reversed += cleanText.charAt(i);
        }

        return cleanText.equals(reversed);
    }

    // method to display result
    void displayResult() {
        if (isPalindrome())
            System.out.println(text + " is palindrome");
        else
            System.out.println(text + " is not Palindrome");
    }

    // main method
    public static void main(String[] args) {

        Palindrome_Checker pal1 = new Palindrome_Checker();
        pal1.text = "A man a plan a canal Panama";

        Palindrome_Checker pal2 = new Palindrome_Checker();
        pal2.text = "Hello";

        pal1.displayResult();
        pal2.displayResult();
    }
}