import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HospitalNotification {

    public static void main(String[] args) {

        List<Alert> alerts = Arrays.asList(
                new Alert("Heart rate high", "CRITICAL"),
                new Alert("Appointment reminder", "INFO"),
                new Alert("Low oxygen level", "CRITICAL"),
                new Alert("System maintenance", "WARNING")
        );

        // Show only CRITICAL alerts
        Predicate<Alert> criticalOnly = a -> a.type.equals("CRITICAL");

        List<Alert> filtered = alerts.stream()
                .filter(criticalOnly)
                .collect(Collectors.toList());

        filtered.forEach(System.out::println);
    }
}
