import java.util.Scanner;

// Custom Exception
class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}

// StudentScores class
class StudentScores {
    private int[] scores;

    // Constructor with validation
    public StudentScores(int[] scores) throws InvalidScoreException {
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
    private StudentScores studentScores;

    // Constructor
    public ScoreAnalyzer(StudentScores studentScores) {
        this.studentScores = studentScores;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int score : studentScores.getScores()) {
            sum += score;
        }
        return (double) sum / studentScores.getScores().length;
    }

    public int findMax() {
        int max = studentScores.getScores()[0];
        for (int score : studentScores.getScores()) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    public int findMin() {
        int min = studentScores.getScores()[0];
        for (int score : studentScores.getScores()) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }
}

// Main Application (UI)
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

            // Create objects
            StudentScores studentScores = new StudentScores(scores);
            ScoreAnalyzer analyzer = new ScoreAnalyzer(studentScores);

            // Display results
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
