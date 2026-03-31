import java.util.Calendar;
import java.util.Date;

public class EnergyMonitorTest {
    public static void main(String[] args) {
        EnergyMonitor monitor = new EnergyMonitor();
        Calendar cal = Calendar.getInstance();

        try {
            cal.set(2026, Calendar.FEBRUARY, 1);
            monitor.addReading(cal.getTime(), 5.5);
            monitor.addReading(cal.getTime(), 6.0);

            cal.set(2026, Calendar.FEBRUARY, 2);
            monitor.addReading(cal.getTime(), 7.2);
            monitor.addReading(cal.getTime(), 6.8);

            cal.set(2026, Calendar.MARCH, 1);
            monitor.addReading(cal.getTime(), 4.5);

            // Uncomment to test exception
            // monitor.addReading(cal.getTime(), -3.0);

        } catch (InvalidEnergyReadingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        monitor.showAllData();

        cal.set(2026, Calendar.FEBRUARY, 1);
        System.out.println("Daily Average (Feb 1): " + monitor.calculateDailyAverage(cal.getTime()));
        System.out.println("Monthly Average (Feb 2026): " + monitor.calculateMonthlyAverage(2, 2026));
        System.out.println("Monthly Average (Mar 2026): " + monitor.calculateMonthlyAverage(3, 2026));
    }
}
