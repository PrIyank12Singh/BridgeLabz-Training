public class CinemaTimeApp {

    public static void main(String[] args) {

        CinemaTimeManager manager = new CinemaTimeManager();

        try {
            manager.addMovie("Inception", "18:30");
            manager.addMovie("Interstellar", "21:00");
            manager.addMovie("Avengers", "15:45");

            // Uncomment to test exception
            // manager.addMovie("InvalidMovie", "25:99");

        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nAll Movies:");
        manager.displayAllMovies();

        System.out.println("\nSearch Result:");
        manager.searchMovie("inter");

        manager.generateReport();
    }
}
