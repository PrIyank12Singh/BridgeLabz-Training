import java.time.LocalDateTime;

public class Reservation {
    private Table table;
    private String customerName;
    private LocalDateTime timeSlot;

    public Reservation(Table table, String customerName, LocalDateTime timeSlot) {
        this.table = table;
        this.customerName = customerName;
        this.timeSlot = timeSlot;
    }

    public Table getTable() {
        return table;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDateTime getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String toString() {
        return customerName + " reserved " + table + " at " + timeSlot;
    }
}
