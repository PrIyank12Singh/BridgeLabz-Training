import java.util.*;

public class IoTSensorMonitorApp {
    public static void main(String[] args) {

        List<Double> readings = Arrays.asList(
                45.2, 60.5, 72.3, 39.8, 88.1
        );

        double threshold = 50.0;

        readings.stream()
                .filter(value -> value > threshold)
                .forEach(value ->
                        System.out.println("Alert Reading: " + value)
                );
    }
}
