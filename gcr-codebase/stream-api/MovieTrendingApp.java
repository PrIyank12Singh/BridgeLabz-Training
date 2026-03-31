import java.util.*;
import java.util.stream.Collectors;

class Movie {
    private String name;
    private double rating;
    private int releaseYear;

    public Movie(String name, double rating, int releaseYear) {
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String getName() { return name; }
    public double getRating() { return rating; }
    public int getReleaseYear() { return releaseYear; }

    @Override
    public String toString() {
        return name + " - " + rating + " - " + releaseYear;
    }
}

public class MovieTrendingApp {
    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
                new Movie("A", 8.5, 2023),
                new Movie("B", 9.0, 2024),
                new Movie("C", 7.5, 2022),
                new Movie("D", 9.0, 2022),
                new Movie("E", 8.8, 2024),
                new Movie("F", 8.0, 2023)
        );

        List<Movie> top5 = movies.stream()
                .filter(m -> m.getRating() > 7.0)  // Intermediate (stateless)
                .sorted(Comparator
                        .comparing(Movie::getRating).reversed()
                        .thenComparing(Movie::getReleaseYear).reversed()) // Stateful
                .limit(5) // Short-circuiting
                .collect(Collectors.toList()); // Terminal

        top5.forEach(System.out::println);
    }
}
