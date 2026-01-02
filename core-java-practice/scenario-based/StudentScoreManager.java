import java.util.Scanner;

class StudentScoreManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] scores = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter score for student " + (i + 1) + ": ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input!");
                    sc.next(); // 
                    continue;
                }

                int score = sc.nextInt();

                if (score < 0) {
                    System.out.println("Score cannot be negative.");
                } else {
                    scores[i] = score;
                    sum += score;
                    break;
                }
            }
        }

        double average = (double) sum / n;
        int max = scores[0];
        int min = scores[0];

        for (int i = 1; i < n; i++) {
            if (scores[i] > max)
                max = scores[i];
            if (scores[i] < min)
                min = scores[i];
        }

        System.out.println("\nAverage Score: " + average);
        System.out.println("Highest Score: " + max);
        System.out.println("Lowest Score: " + min);

        System.out.println("\nScores above average:");
        for (int score : scores) {
            if (score > average) {
                System.out.println(score);
            }
        }

        sc.close();
    }
}
