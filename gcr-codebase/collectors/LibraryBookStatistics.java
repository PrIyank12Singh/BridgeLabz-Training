import java.util.*;
import java.util.stream.*;

class Book {
    String title;
    String genre;
    int pages;

    Book(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getPages() { return pages; }

    @Override
    public String toString() {
        return title + " (" + genre + ", " + pages + " pages)";
    }
}

public class LibraryBookStatistics {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Java Basics", "Programming", 300),
            new Book("Advanced Java", "Programming", 450),
            new Book("World History", "History", 500),
            new Book("Modern History", "History", 400),
            new Book("Cooking 101", "Cooking", 250)
        );

        // Summarize pages per genre
        Map<String, IntSummaryStatistics> statsByGenre = books.stream()
            .collect(Collectors.groupingBy(
                Book::getGenre,
                Collectors.summarizingInt(Book::getPages)
            ));

        // Display results
        statsByGenre.forEach((genre, stats) -> {
            System.out.println("Genre: " + genre);
            System.out.println("  Total Pages: " + stats.getSum());
            System.out.println("  Average Pages: " + stats.getAverage());
            System.out.println("  Max Pages: " + stats.getMax());
            System.out.println("  Min Pages: " + stats.getMin());
            System.out.println("  Count: " + stats.getCount());
            System.out.println();
        });
    }
}
