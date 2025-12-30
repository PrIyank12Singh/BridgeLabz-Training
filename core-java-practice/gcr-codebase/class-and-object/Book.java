class Book {

    // instance variables
    String title;
    String author;
    double price;

    // method to display book details
    void displayBookDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }

    // main method
    public static void main(String[] args) {

        // Creating first book object
        Book book1 = new Book();
        book1.title = "2States";
        book1.author = "Chetan Bhagat";
        book1.price = 500.0;

        // Creating second book object
        Book book2 = new Book();
        book2.title = "Wings Of Fire";
        book2.author = "Abdul kalam.A.P.J";
        book2.price = 500.0;

        // Displaying book details
        book1.displayBookDetails();
        System.out.println();
        book2.displayBookDetails();
    }
}
