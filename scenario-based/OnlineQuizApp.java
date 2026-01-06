import java.util.ArrayList;
import java.util.Scanner;

// Custom Exception
class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

// Quiz class
class Quiz {
    private String[] correctAnswers;

    // Constructor
    public Quiz(String[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public String[] getCorrectAnswers() {
        return correctAnswers;
    }
}

// User Submission class
class QuizSubmission {
    private String[] userAnswers;

    // Constructor
    public QuizSubmission(String[] userAnswers) {
        this.userAnswers = userAnswers;
    }

    public String[] getUserAnswers() {
        return userAnswers;
    }
}

// Result Processor (BUSINESS LOGIC)
class ResultProcessor {
    private Quiz quiz;
    private ArrayList<Integer> allScores;

    // Constructor
    public ResultProcessor(Quiz quiz) {
        this.quiz = quiz;
        this.allScores = new ArrayList<>();
    }

    // Compare answers and calculate score
    public int calculateScore(QuizSubmission submission) throws InvalidQuizSubmissionException {
        String[] correct = quiz.getCorrectAnswers();
        String[] user = submission.getUserAnswers();

        if (correct.length != user.length) {
            throw new InvalidQuizSubmissionException(
                "Answer count mismatch. Expected " + correct.length + " answers."
            );
        }

        int score = 0;
        for (int i = 0; i < correct.length; i++) {
            if (correct[i].equalsIgnoreCase(user[i])) {
                score++;
            }
        }

        allScores.add(score);
        return score;
    }

    // Return grade based on score
    public String getGrade(int score) {
        if (score >= 8) return "A";
        if (score >= 6) return "B";
        if (score >= 4) return "C";
        return "F";
    }

    // Display all user scores
    public void displayAllScores() {
        System.out.println("\n   All User Scores  ");
        for (int i = 0; i < allScores.size(); i++) {
            System.out.println("User " + (i + 1) + ": " + allScores.get(i));
        }
    }
}

// Main Application 
public class OnlineQuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Correct answers
        String[] correctAnswers = {"A", "C", "B", "D", "A", "B", "C", "D", "A", "C"};
        Quiz quiz = new Quiz(correctAnswers);
        ResultProcessor processor = new ResultProcessor(quiz);

        System.out.print("Enter number of users: ");
        int users = sc.nextInt();
        sc.nextLine();

        for (int u = 1; u <= users; u++) {
            System.out.println("\nEnter answers for User " + u + ":");
            String[] userAnswers = new String[correctAnswers.length];

            for (int i = 0; i < userAnswers.length; i++) {
                System.out.print("Q" + (i + 1) + ": ");
                userAnswers[i] = sc.nextLine();
            }

            QuizSubmission submission = new QuizSubmission(userAnswers);

            try {
                int score = processor.calculateScore(submission);
                String grade = processor.getGrade(score);

                System.out.println("Score: " + score + "/" + correctAnswers.length);
                System.out.println("Grade: " + grade);

            } catch (InvalidQuizSubmissionException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        processor.displayAllScores();
        sc.close();
    }
}
