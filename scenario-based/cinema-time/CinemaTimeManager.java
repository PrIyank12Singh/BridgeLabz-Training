import java.util.ArrayList;
import java.util.List;

public class CinemaTimeManager {

    private List<String> movieTitles = new ArrayList<>();
    private List<String> showTimes = new ArrayList<>();

    // Add movie
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }

        movieTitles.add(title);
        showTimes.add(time);
    }

    // Search movie by keyword
    public void searchMovie(String keyword) {
        boolean found = false;

        for (int i = 0; i < movieTitles.size(); i++) {
            try {
                if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                    String result = String.format(
                            "Movie: %s | Time: %s",
                            movieTitles.get(i),
                            showTimes.get(i)
                    );
                    System.out.println(result);
                    found = true;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Data mismatch at index: " + i);
            }
        }

        if (!found) {
            System.out.println("No movie found with keyword: " + keyword);
        }
    }

    // Display all movies
    public void displayAllMovies() {
        if (movieTitles.isEmpty()) {
            System.out.println("No movies available.");
            return;
        }

        for (int i = 0; i < movieTitles.size(); i++) {
            try {
                String output = String.format(
                        "Movie: %s | Time: %s",
                        movieTitles.get(i),
                        showTimes.get(i)
                );
                System.out.println(output);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error displaying movie at index: " + i);
            }
        }
    }

    // Convert List to Array for report
    public void generateReport() {
        String[] titlesArray = movieTitles.toArray(new String[0]);
        String[] timesArray = showTimes.toArray(new String[0]);

        System.out.println("\n--- Printable Movie Report ---");
        for (int i = 0; i < titlesArray.length; i++) {
            System.out.println(titlesArray[i] + " at " + timesArray[i]);
        }
    }

    // Time validation (HH:MM)
    private boolean isValidTime(String time) {
        if (!time.matches("\\d{2}:\\d{2}")) {
            return false;
        }

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);

        return hour >= 0 && hour <= 23 && min >= 0 && min <= 59;
    }
}
