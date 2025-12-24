import java.util.Scanner;

public class StudentScorecard {

    // Method to generate random 2-digit scores for Physics, Chemistry, Math
    public static int[][] generateScores(int students) {
        int[][] scores = new int[students][3]; // 3 subjects
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 10 + (int)(Math.random() * 91); // random 10-99
            }
        }
        return scores;
    }

    // Method to calculate total, average, percentage for each student
    public static double[][] calculateTotals(int[][] scores) {
        int students = scores.length;
        double[][] results = new double[students][3]; // total, average, percentage

        for (int i = 0; i < students; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Round off to 2 decimal places
            results[i][0] = Math.round(total * 100.0) / 100.0;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    // Method to calculate grade based on average
    public static String calculateGrade(double average) {
        if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 60) return "C";
        else if (average >= 50) return "D";
        else if (average >= 40) return "E";
        else return "R";
    }

    // Method to calculate remark based on average
    public static String calculateRemark(double average) {
        if (average >= 80) return "(Level 4, above agency-normalized standards)";
        else if (average >= 70) return "(Level 3, at agency-normalized standards)";
        else if (average >= 60) return "(Level 2, below, but approaching agency-normalized standards)";
        else if (average >= 50) return "(Level 1, well below agency-normalized standards)";
        else if (average >= 40) return "(Level 1-, too below agency-normalized standards)";
        else return "(Remedial Standards)";
    }

    // Method to display the scorecard with grade and remark
    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade\tRemark");
        for (int i = 0; i < scores.length; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < 3; j++) {
                System.out.print(scores[i][j] + "\t");
            }
            double avg = results[i][1];
            System.out.print(results[i][0] + "\t" + avg + "\t" + results[i][2] + "\t");
            System.out.print(calculateGrade(avg) + "\t" + calculateRemark(avg));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[][] scores = generateScores(n);
        double[][] results = calculateTotals(scores);
        displayScorecard(scores, results);

        scanner.close();
    }
}
