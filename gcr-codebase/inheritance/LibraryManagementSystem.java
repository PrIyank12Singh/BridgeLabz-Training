class Author {

    private String name;
    private String bio;

    //parameterized constructor
    public Author(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public void displayAuthorInfo() {
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

class Book {

    private String title;
    private int publicationYear;
    private Author author; // has a relationship

    public Book(String title, int publicationYear, Author author) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
        author.displayAuthorInfo();
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Author author = new Author(
                "S.Chand",
                "English novelist and essayist, critic of totalitarianism"
        );

        Book book = new Book(
                "2000",
                2015,
                author
        );

        book.displayInfo();
    }
}
