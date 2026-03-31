import java.util.*;
import java.time.LocalDateTime;

public class Restaurant {
    private Map<Integer, Table> tables = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();

    // Add tables to restaurant
    public void addTable(Table table) {
        tables.put(table.getTableNumber(), table);
    }

    // Reserve a table
    public void reserveTable(int tableNumber, String customerName, LocalDateTime timeSlot) throws TableAlreadyReservedException {
        Table table = tables.get(tableNumber);
        if (table == null) {
            System.out.println("Table " + tableNumber + " does not exist.");
            return;
        }

        // Check for double booking
        for (Reservation r : reservations) {
            if (r.getTable().getTableNumber() == tableNumber && r.getTimeSlot().equals(timeSlot)) {
                throw new TableAlreadyReservedException("Table " + tableNumber + " is already reserved at " + timeSlot);
            }
        }

        reservations.add(new Reservation(table, customerName, timeSlot));
        System.out.println("Reservation successful for " + customerName + " at Table " + tableNumber + " on " + timeSlot);
    }

    // Cancel a reservation
    public void cancelReservation(int tableNumber, LocalDateTime timeSlot) {
        reservations.removeIf(r -> r.getTable().getTableNumber() == tableNumber && r.getTimeSlot().equals(timeSlot));
        System.out.println("Reservation for Table " + tableNumber + " at " + timeSlot + " cancelled.");
    }

    // Show available tables for a specific time slot
    public void showAvailableTables(LocalDateTime timeSlot) {
        System.out.println("Available tables for " + timeSlot + ":");
        for (Table table : tables.values()) {
            boolean isReserved = false;
            for (Reservation r : reservations) {
                if (r.getTable().getTableNumber() == table.getTableNumber() && r.getTimeSlot().equals(timeSlot)) {
                    isReserved = true;
                    break;
                }
            }
            if (!isReserved) {
                System.out.println(table);
            }
        }
    }
}
