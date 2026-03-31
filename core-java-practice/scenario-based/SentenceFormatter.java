class SentenceFormatter {

    static String formatParagraph(String paragraph) {

        // handle empty or only spaces
        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "Empty paragraph";
        }

        // remove extra spaces
        paragraph = paragraph.trim().replaceAll("\\s+", " ");

        // ensure one space after punctuation
        paragraph = paragraph.replaceAll("([.!?])\\s*", "$1 ");

        // capitalize first letter of each sentence
        String[] sentences = paragraph.split("(?<=[.!?]) ");
        StringBuilder formatted = new StringBuilder();

        for (String s : sentences) {
            formatted.append(
                Character.toUpperCase(s.charAt(0))
                + s.substring(1)
                + " "
            );
        }

        return formatted.toString().trim();
    }

    public static void main(String[] args) {
        String input = "  hello world.this is java! how are you?   ";

        System.out.println(formatParagraph(input));
    }
}
