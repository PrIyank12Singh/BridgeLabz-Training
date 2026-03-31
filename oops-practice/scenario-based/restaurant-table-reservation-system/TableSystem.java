import java.time.LocalDateTime;

public class TableSystem {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        // Add tables
        restaurant.addTable(new Table(1, 4));
        restaurant.addTable(new Table(2, 2));
        restaurant.addTable(new Table(3, 6));

        LocalDateTime time1 = LocalDateTime.of(2026, 1, 28, 19, 0);
        LocalDateTime time2 = LocalDateTime.of(2026, 1, 28, 20, 0);

        try {
            restaurant.reserveTable(1, "Alice", time1);
            restaurant.reserveTable(2, "Bob", time1);
            restaurant.reserveTable(1, "Charlie", time1); // Should throw exception
        } catch (TableAlreadyReservedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        restaurant.showAvailableTables(time1);
        restaurant.showAvailableTables(time2);

        restaurant.cancelReservation(1, time1);
        restaurant.showAvailableTables(time1);
    }
}
