import java.util.*;

// custom Exception
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// book class
class Book {
    String title;
    String author;
    boolean isAvailable;

    Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    void displayBook() {
        System.out.println(
                "Title: " + title +
                ", Author: " + author +
                ", Status: " + (isAvailable ? "Available" : "Checked Out")
        );
    }
}

public class LibraryManagement {

    // search book by partial title
    static void searchBook(List<Book> books, String keyword) {
        boolean found = false;

        for (Book book : books) {
            if (book.title.toLowerCase().contains(keyword.toLowerCase())) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found with title: " + keyword);
        }
    }

    // checkout book
    static void checkoutBook(List<Book> books, String title)
            throws BookNotAvailableException {

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {

                if (!book.isAvailable) {
                    throw new BookNotAvailableException(
                            "Book is already checked out!"
                    );
                }

                book.isAvailable = false;
                System.out.println("Book checked out successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {

        // Store book data in Array
        Book[] bookArray = {
                new Book("Java Programming", "James Gosling", true),
                new Book("Data Structures", "Mark Weiss", true),
                new Book("Operating Systems", "Galvin", false)
        };

        // Convert Array to List
        List<Book> books = new ArrayList<>(Arrays.asList(bookArray));

        System.out.println("Search Results: ");
        searchBook(books, "data");

        try {
            System.out.println("\nCheckout Book:");
            checkoutBook(books, "Operating Systems");
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n All Books:");
        for (Book book : books) {
            book.displayBook();
        }
    }
}
