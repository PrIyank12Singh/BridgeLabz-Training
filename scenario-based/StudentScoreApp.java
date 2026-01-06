import java.util.Scanner;

// Custom Exception
class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}

// ScoreData class (MODEL)
class ScoreData {
    private int[] scores;

    // Constructor with validation
    public ScoreData(int[] scores) throws InvalidScoreException {
        for (int score : scores) {
            if (score < 0 || score > 100) {
                throw new InvalidScoreException(
                    "Invalid score detected: " + score + ". Score must be between 0 and 100."
                );
            }
        }
        this.scores = scores;
    }

    public int[] getScores() {
        return scores;
    }
}

// Analyzer class (BUSINESS LOGIC)
class ScoreAnalyzer {
    private ScoreData scoreData;

    // Constructor
    public ScoreAnalyzer(ScoreData scoreData) {
        this.scoreData = scoreData;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int score : scoreData.getScores()) {
            sum += score;
        }
        return (double) sum / scoreData.getScores().length;
    }

    public int findMax() {
        int max = scoreData.getScores()[0];
        for (int score : scoreData.getScores()) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    public int findMin() {
        int min = scoreData.getScores()[0];
        for (int score : scoreData.getScores()) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }
}

// Main Application
public class StudentScoreApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of students: ");
            int n = sc.nextInt();

            int[] scores = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter score for student " + (i + 1) + ": ");
                scores[i] = sc.nextInt();
            }

            ScoreData scoreData = new ScoreData(scores);
            ScoreAnalyzer analyzer = new ScoreAnalyzer(scoreData);

            System.out.println("\n--- Score Analysis Report ---");
            System.out.printf("Average Score : %.2f%n", analyzer.calculateAverage());
            System.out.println("Highest Score : " + analyzer.findMax());
            System.out.println("Lowest Score  : " + analyzer.findMin());

        } catch (InvalidScoreException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
