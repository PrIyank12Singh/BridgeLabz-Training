class BookShelf {
    private Book[] books;
    private int size;

    public BookShelf(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(Book book) {
        if (size == books.length) {
            System.out.println("Shelf is full. Cannot add more books.");
            return;
        }

        books[size] = book;
        size++;

        insertionSort();

        System.out.println("Book added and shelf sorted.");
    }

    private void insertionSort() {
        for (int i = 1; i < size; i++) {
            Book key = books[i];
            int j = i - 1;

            while (j >= 0 && books[j].title.compareToIgnoreCase(key.title) > 0) {
                books[j + 1] = books[j];
                j--;
            }

            books[j + 1] = key;
        }
    }

    public void displayShelf() {
        if (size == 0) {
            System.out.println("Shelf is empty.");
            return;
        }

        System.out.println("Books on SmartShelf (Alphabetical Order):");
        for (int i = 0; i < size; i++) {
            books[i].display();
        }
    }
}
