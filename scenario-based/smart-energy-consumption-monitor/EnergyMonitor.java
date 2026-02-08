import java.util.*;

class EnergyMonitor {
    private Map<Date, List<Double>> energyData;

    public EnergyMonitor() {
        energyData = new HashMap<>();
    }

    // Add a reading for a specific date
    public void addReading(Date date, double reading) throws InvalidEnergyReadingException {
        if (reading < 0) {
            throw new InvalidEnergyReadingException("Energy reading cannot be negative: " + reading);
        }

        energyData.putIfAbsent(date, new ArrayList<>());
        energyData.get(date).add(reading);
        System.out.println("Added reading " + reading + " for " + date);
    }

    // Calculate average energy usage for a specific day
    public double calculateDailyAverage(Date date) {
        List<Double> readings = energyData.get(date);
        if (readings == null || readings.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (double r : readings) {
            sum += r;
        }
        return sum / readings.size();
    }

    // Calculate average energy usage for a specific month
    public double calculateMonthlyAverage(int month, int year) {
        double sum = 0;
        int count = 0;

        Calendar cal = Calendar.getInstance();
        for (Date date : energyData.keySet()) {
            cal.setTime(date);
            int dMonth = cal.get(Calendar.MONTH) + 1; // January=0
            int dYear = cal.get(Calendar.YEAR);

            if (dMonth == month && dYear == year) {
                List<Double> readings = energyData.get(date);
                for (double r : readings) {
                    sum += r;
                    count++;
                }
            }
        }

        return count == 0 ? 0 : sum / count;
    }

    // Display all readings
    public void showAllData() {
        for (Map.Entry<Date, List<Double>> entry : energyData.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
