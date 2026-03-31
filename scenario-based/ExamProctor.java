import java.util.*;

public class ExamProctor {

    // System
    static class ExamSystem {

        private Stack<Integer> navigationStack = new Stack<>();
        private HashMap<Integer, String> answersMap = new HashMap<>();
        private HashMap<Integer, String> correctAnswers = new HashMap<>();

        public ExamSystem() {
            // Preload correct answers
            correctAnswers.put(1, "A");
            correctAnswers.put(2, "C");
            correctAnswers.put(3, "B");
            correctAnswers.put(4, "D");
        }

        // Track navigation
        public void visitQuestion(int questionId) {
            navigationStack.push(questionId);
            System.out.println("Visited Question: " + questionId);
        }

        // Store answers
        public void submitAnswer(int questionId, String answer) {
            answersMap.put(questionId, answer);
            System.out.println("Saved Answer: Q" + questionId + " -> " + answer);
        }

        // Review last visited question
        public Integer getLastVisitedQuestion() {
            if (navigationStack.isEmpty()) return null;
            return navigationStack.peek();
        }

        // Scoring function
        public int calculateScore() {
            int score = 0;

            for (Map.Entry<Integer, String> entry : answersMap.entrySet()) {
                int qId = entry.getKey();
                String studentAnswer = entry.getValue();

                if (studentAnswer.equals(correctAnswers.get(qId))) {
                    score++;
                }
            }

            return score;
        }

        // Submit exam
        public void submitExam() {
            System.out.println("\nSubmitting Exam...");

            int finalScore = calculateScore();
            System.out.println("Final Score: " + finalScore + "/" + correctAnswers.size());
        }
    }

    // Main
    public static void main(String[] args) {

        ExamSystem system = new ExamSystem();

        system.visitQuestion(1);
        system.submitAnswer(1, "A");

        system.visitQuestion(2);
        system.submitAnswer(2, "B");

        system.visitQuestion(3);
        system.submitAnswer(3, "B");

        system.visitQuestion(4);
        system.submitAnswer(4, "D");

        System.out.println("\nLast Visited Question: " + system.getLastVisitedQuestion());

        system.submitExam();
    }
}
