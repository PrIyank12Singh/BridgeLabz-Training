import java.util.*;

public class BookShelf {

    // Book Model
    static class Book {
        String title;
        String author;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        // Needed for HashSet duplicate prevention
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Book)) return false;
            Book other = (Book) obj;
            return title.equalsIgnoreCase(other.title) &&
                  author.equalsIgnoreCase(other.author);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title.toLowerCase(), author.toLowerCase());
        }

        @Override
        public String toString() {
            return title + " by " + author;
        }
    }

    // Library System
    static class LibrarySystem {

        // genre -> list of books
        private Map<String, LinkedList<Book>> catalog = new HashMap<>();

        // prevents duplicate books
        private Set<Book> uniqueBooks = new HashSet<>();

        // Add book
        public void addBook(String genre, Book book) {

            if (uniqueBooks.contains(book)) {
                System.out.println("Duplicate book ignored: " + book);
                return;
            }

            catalog.putIfAbsent(genre, new LinkedList<>());
            catalog.get(genre).add(book);
            uniqueBooks.add(book);

            System.out.println("Book added: " + book + " [Genre: " + genre + "]");
        }

        // Borrow book
        public void borrowBook(String genre, String title) {

            LinkedList<Book> books = catalog.get(genre);

            if (books == null || books.isEmpty()) {
                System.out.println("No books available in genre: " + genre);
                return;
            }

            Iterator<Book> iterator = books.iterator();

            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (book.title.equalsIgnoreCase(title)) {
                    iterator.remove();
                    uniqueBooks.remove(book);
                    System.out.println("Book borrowed: " + book);
                    return;
                }
            }

            System.out.println("Book not found: " + title);
        }

        // Return book
        public void returnBook(String genre, Book book) {
            addBook(genre, book);
            System.out.println("Book returned: " + book);
        }

        // Display catalog
        public void printCatalog() {
            System.out.println("\n   Library Catalog  ");

            if (catalog.isEmpty()) {
                System.out.println("Library is empty.");
                return;
            }

            for (String genre : catalog.keySet()) {
                System.out.println("Genre: " + genre);
                for (Book book : catalog.get(genre)) {
                    System.out.println("   - " + book);
                }
            }
        }
    }

    //Main
    public static void main(String[] args) {

        LibrarySystem library = new LibrarySystem();

        library.addBook("Fiction", new Book("1984", "George Orwell"));
        library.addBook("Fiction", new Book("The Alchemist", "Paulo Coelho"));
        library.addBook("Science", new Book("A Brief History of Time", "Stephen Hawking"));

        // Duplicate test
        library.addBook("Fiction", new Book("1984", "George Orwell"));

        library.printCatalog();

        // Borrow
        library.borrowBook("Fiction", "1984");

        library.printCatalog();

        // Return
        library.returnBook("Fiction", new Book("1984", "George Orwell"));

        library.printCatalog();
    }
}
