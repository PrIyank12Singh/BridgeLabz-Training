import java.util.Scanner;

class BookNode {
    int id;
    String title, author, genre;
    boolean available;
    BookNode next, prev;

    BookNode(int id, String title, String author, String genre, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
        next = prev = null;
    }
}

class Library {
    private BookNode head, tail;

    // add at end
    void addBook(BookNode book) {
        if (head == null) {
            head = tail = book;
            return;
        }
        tail.next = book;
        book.prev = tail;
        tail = book;
    }

    // remove by ID
    void removeBook(int id) {
        BookNode temp = head;

        while (temp != null && temp.id != id)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Book not found");
            return;
        }

        if (temp == head)
            head = temp.next;
        if (temp == tail)
            tail = temp.prev;

        if (temp.prev != null)
            temp.prev.next = temp.next;
        if (temp.next != null)
            temp.next.prev = temp.prev;

        System.out.println("Book removed");
    }

    // Search by title or author
    void search(String key) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(key) || temp.author.equalsIgnoreCase(key))
                print(temp);
            temp = temp.next;
        }
    }

    // update availability
    void updateAvailability(int id, boolean status) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.available = status;
                System.out.println("Availability updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    // display forward
    void displayForward() {
        BookNode temp = head;
        while (temp != null) {
            print(temp);
            temp = temp.next;
        }
    }

    // display reverse
    void displayReverse() {
        BookNode temp = tail;
        while (temp != null) {
            print(temp);
            temp = temp.prev;
        }
    }

    // count books
    void countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total books = " + count);
    }

    void print(BookNode b) {
        System.out.println(
            b.id + " | " + b.title + " | " + b.author + " | " +
            b.genre + " | " + (b.available ? "Available" : "Issued")
        );
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n1.Add 2.Remove 3.Search 4.Update Status 5.Forward 6.Reverse 7.Count 8.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    lib.addBook(new BookNode(
                        sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextBoolean()));
                    break;
                case 2:
                    lib.removeBook(sc.nextInt());
                    break;
                case 3:
                    lib.search(sc.next());
                    break;
                case 4:
                    lib.updateAvailability(sc.nextInt(), sc.nextBoolean());
                    break;
                case 5:
                    lib.displayForward();
                    break;
                case 6:
                    lib.displayReverse();
                    break;
                case 7:
                    lib.countBooks();
                    break;
                case 8:
                    sc.close(); 
                    return;
            }
        }
    }
}
