class BooK {
    String title;
    String author;
    double price;

    // Default constructor
    BooK() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized constructor
    BooK(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
