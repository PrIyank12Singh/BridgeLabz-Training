import java.util.*;

// Custom Exception
class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

class QuizProcessor {

    // Compare answers and calculate score
    public static int calculateScore(
            String[] correctAnswers,
            String[] userAnswers)
            throws InvalidQuizSubmissionException {

        if (correctAnswers.length != userAnswers.length) {
            throw new InvalidQuizSubmissionException(
                "Answers does not match"
            );
        }

        int score = 0;

        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }

    // Return grade based on score
    public static String getGrade(int score, int total) {
        double percentage = (score * 100.0) / total;

        if (percentage >= 80) return "A";
        else if (percentage >= 60) return "B";
        else if (percentage >= 40) return "C";
        else return "F";
    }
}

public class OnlineQuizPlatform {

    public static void main(String[] args) {

        String[] correctAnswers = {"A", "B", "C", "D", "A"};

        List<Integer> scores = new ArrayList<>();

        try {
            String[] user1 = {"A", "B", "C", "D", "A"};
            String[] user2 = {"A", "C", "C", "D", "B"};

            int score1 = QuizProcessor.calculateScore(correctAnswers, user1);
            int score2 = QuizProcessor.calculateScore(correctAnswers, user2);

            scores.add(score1);
            scores.add(score2);

            System.out.println("User 1 Score: " + score1 +
                    ", Grade: " + QuizProcessor.getGrade(score1, correctAnswers.length));

            System.out.println("User 2 Score: " + score2 +
                    ", Grade: " + QuizProcessor.getGrade(score2, correctAnswers.length));

        } catch (InvalidQuizSubmissionException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("All Scores: " + scores);
    }
}
