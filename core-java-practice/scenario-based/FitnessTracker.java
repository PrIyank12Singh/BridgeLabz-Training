public class FitnessTracker {
    public static void main(String[] args) {

        // Push-ups for 7 days (0 = rest day)
        int[] pushUps = {20, 25, 0, 30, 35, 0, 40};

        int total = 0;
        int workoutDays = 0;

        for (int day : pushUps) {
            if (day == 0) {
                continue; // skip rest day
            }
            total += day;
            workoutDays++;
        }

        double average = (double) total / workoutDays;

        System.out.println("Total Push-ups: " + total);
        System.out.println("Average Push-ups per workout day: " + average);
    }
}
