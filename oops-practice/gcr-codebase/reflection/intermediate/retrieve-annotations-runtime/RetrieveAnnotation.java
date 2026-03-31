public class RetrieveAnnotation {

    public static void main(String[] args) {

        try {
            // Get Class object
            Class<Book> cls = Book.class;

            // Check if annotation is present
            if (cls.isAnnotationPresent(Author.class)) {

                // Get annotation
                Author author = cls.getAnnotation(Author.class);

                // Display annotation value
                System.out.println("Author Name: " + author.name());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
