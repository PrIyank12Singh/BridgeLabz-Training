class TemperatureAnalyzer {

    // method to analyze temperatures
    static void analyzeTemperature(float[][] temp) {
        float maxTemp = temp[0][0];
        float minTemp = temp[0][0];
        int hottestDay = 0;
        int coldestDay = 0;

        for (int day = 0; day < 7; day++) {
            float dailySum = 0;

            for (int hour = 0; hour < 24; hour++) {
                float current = temp[day][hour];
                dailySum += current;

                if (current > maxTemp) {
                    maxTemp = current;
                    hottestDay = day;
                }

                if (current < minTemp) {
                    minTemp = current;
                    coldestDay = day;
                }
            }

            System.out.println("Average temperature of Day "
                    + (day + 1) + ": " + (dailySum / 24));
        }

        System.out.println("\nHottest Day: Day " + (hottestDay + 1)
                + " with temperature " + maxTemp);
        System.out.println("Coldest Day: Day " + (coldestDay + 1)
                + " with temperature " + minTemp);
    }

    public static void main(String[] args) {

        float[][] temperatures = new float[7][24];

        // sample data
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                temperatures[i][j] = 20 + i + (j % 5);
            }
        }

        analyzeTemperature(temperatures);
    }
}
