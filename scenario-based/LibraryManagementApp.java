import java.util.ArrayList;
import java.util.Scanner;

// Custom Exception
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// Book class
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // default status
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkout() throws BookNotAvailableException {
        if (!isAvailable) {
            throw new BookNotAvailableException("Book already checked out: " + title);
        }
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }
}

// Library class
class Library {
    private ArrayList<Book> bookList;

    // Constructor
    public Library(Book[] books) {
        bookList = new ArrayList<>();
        for (Book b : books) {
            bookList.add(b);
        }
    }

    // Display all books
    public void displayBooks() {
        System.out.println("\n  Library Books    ");
        for (Book b : bookList) {
            System.out.println(
                b.getTitle() + " | " +
                b.getAuthor() + " | " +
                (b.isAvailable() ? "Available" : "Checked Out")
            );
        }
    }

    // Search by partial title
    public void searchByTitle(String keyword) {
        boolean found = false;
        System.out.println("\nSearch Results:");
        for (Book b : bookList) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b.getTitle() + " by " + b.getAuthor());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found matching: " + keyword);
        }
    }

    // Checkout book by title
    public void checkoutBook(String title) throws BookNotAvailableException {
        for (Book b : bookList) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.checkout();
                System.out.println("Book checked out successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

// Main Application
public class LibraryManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Book data stored in Array
        Book[] books = {
            new Book("Clean Code", "Robert C. Martin"),
            new Book("Effective Java", "Joshua Bloch"),
            new Book("Head First Java", "Kathy Sierra"),
            new Book("Design Patterns", "GoF"),
            new Book("Java Concurrency", "Brian Goetz")
        };

        // Create Library object
        Library library = new Library(books);

        while (true) {
            System.out.println("\n1. Display Books");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Checkout Book");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        library.displayBooks();
                        break;

                    case 2:
                        System.out.print("Enter title keyword: ");
                        library.searchByTitle(sc.nextLine());
                        break;

                    case 3:
                        System.out.print("Enter book title to checkout: ");
                        library.checkoutBook(sc.nextLine());
                        break;

                    case 4:
                        System.out.println("Exiting Library System.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (BookNotAvailableException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
