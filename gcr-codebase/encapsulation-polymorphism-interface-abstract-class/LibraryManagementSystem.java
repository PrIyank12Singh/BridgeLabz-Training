import java.util.*;

// Interface
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Abstract Class
abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    //Encapsulated
    String borrowerName;
    private boolean isAvailable = true;

    // Constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Encapsulation (Controlled access)
    public boolean isAvailable() {
        return isAvailable;
    }

    protected void assignBorrower(String name) {
        this.borrowerName = name;
        this.isAvailable = false;
    }

    protected void returnItem() {
        this.borrowerName = null;
        this.isAvailable = true;
    }

    // abstract method
    public abstract int getLoanDuration();

    // concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
    }
}
class Book extends LibraryItem implements Reservable {

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // 3 weeks
    }

    @Override
    public void reserveItem() {
        if (isAvailable()) {
            assignBorrower("Student");
            System.out.println("Book reserved successfully");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

class Magazine extends LibraryItem {

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }
}

class DVD extends LibraryItem implements Reservable {

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 5; // 5 days
    }

    @Override
    public void reserveItem() {
        if (isAvailable()) {
            assignBorrower("Guest");
            System.out.println("DVD reserved successfully");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// main Class
public class LibraryManagementSystem {

    public static void main(String[] args) {

        List<LibraryItem> items = new ArrayList<>();

        items.add(new Book(10, "Clean Code", "Robert C. Martin"));
        items.add(new Magazine(11, "Java Monthly", "Oracle"));
        items.add(new DVD(12, "Inception", "Nolan"));

        // polymorphism
        for (LibraryItem item : items) {
            item.getItemDetails();

            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                System.out.println("Available: " + r.checkAvailability());
            }

            System.out.println();
        }
    }
}
