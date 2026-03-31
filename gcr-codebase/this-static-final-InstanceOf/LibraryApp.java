import java.util.Scanner;

class Book {

    //static variable is shared by all books
    static String libraryName = "Egmore Library";

    // instance variables
    String title;
    String author;

    // final variable
    final String isbn;

    //constructor using this
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // static method
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // method to display book details
    void displayDetails(Object obj) {

        //instanceof check
        if (obj instanceof Book) {
            Book b = (Book) obj;
            System.out.println("Title: " + b.title);
            System.out.println("Author: " + b.author);
            System.out.println("ISBN: " + b.isbn);
        } else {
            System.out.println("Object is not a Book");
        }
    }
}

public class LibraryApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Taking input
        String title = sc.nextLine();

        
        String author = sc.nextLine();

        String isbn = sc.nextLine();

        // create Book object
        Book book = new Book(title, author, isbn);

        // display library name
        Book.displayLibraryName();

        // display book details
        book.displayDetails(book);

        sc.close();
    }
}
