class LibraryManagementSystem {

    static String[] titles = {
        "Java Programming",
        "Data Structures",
        "Operating Systems",
        "Computer Networks"
    };

    static String[] authors = {
        "James Gosling",
        "Mark Allen",
        "Silberschatz",
        "Tanenbaum"
    };

    static String[] status = {
        "Available",
        "Available",
        "Checked Out",
        "Available"
    };

    // display all books
    static void displayBooks() {
        System.out.println("Library Books:");
        for (int i = 0; i < titles.length; i++) {
            System.out.println(
                (i + 1) + ". " + titles[i] + " | " + authors[i] + " | " + status[i]
            );
        }
    }

    // search book by partial title
    static void searchBook(String keyword) {
        System.out.println("\nSearch Results:");
        boolean found = false;

        for (int i = 0; i < titles.length; i++) {
            if (titles[i].toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(
                    titles[i] + " | " + authors[i] + " | " + status[i]
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("No book found with given keyword.");
        }
    }

    // checkout book
    static void checkoutBook(String title) {
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].equalsIgnoreCase(title)) {
                if (status[i].equals("Available")) {
                    status[i] = "Checked Out";
                    System.out.println(title + " has been checked out.");
                } else {
                    System.out.println(title + " is already checked out.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {
        displayBooks();
        searchBook("Java");
        checkoutBook("Java Programming");
        displayBooks();
    }
}
