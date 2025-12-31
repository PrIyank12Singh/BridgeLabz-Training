class LibraryBook {
    String title;
    String author;
    double price;
    boolean available = true;

    //Default Constructor
    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully");
        } else {
            System.out.println("Book not Available");
        }
    }
}
