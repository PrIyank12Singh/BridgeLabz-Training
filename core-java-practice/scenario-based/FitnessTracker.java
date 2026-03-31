import java.util.*;
public class FitnessTracker {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        // Push-ups for 7 days (0 = rest day)
        int[] pushUps = new int[7] ;

        for (int i = 0; i < pushUps.length; i++) {
          pushUps[i] = scan.nextInt();
        }

        int totalPushUps = 0;
        int workoutDays = 0;

        for (int day : pushUps) {
            if (day == 0) {
                continue; // skip rest day
            }
            totalPushUps += day;
            workoutDays++;
        }

        double average = (double) totalPushUps / workoutDays;

        System.out.println("Total Push-ups: " + totalPushUps);
        System.out.println("Average Push-ups per workout day: " + average);

        scan.close();
    }
}
