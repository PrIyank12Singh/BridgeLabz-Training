import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookShelf shelf = new BookShelf(50);

        while (true) {
            System.out.println("\n--- SmartShelf Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Shelf");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();

                    shelf.addBook(new Book(title, author));
                    break;

                case 2:
                    shelf.displayShelf();
                    break;

                case 3:
                    System.out.println("SmartShelf closed.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
