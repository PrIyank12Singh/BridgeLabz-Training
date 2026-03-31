import java.util.HashMap;
import java.util.Map;

public class ParticipantEntry {

    private String name;
    private int submissionTime;
    private Map<String, Boolean> testCaseResults;
    private int score;

    public ParticipantEntry(String name, int submissionTime) {
        this.name = name;
        this.submissionTime = submissionTime;
        this.testCaseResults = new HashMap<>();
    }

    public void addTestCaseResult(String questionId, boolean result) {
        testCaseResults.put(questionId, result);
    }

    public void calculateScore() {
        int total = 0;
        for (Boolean result : testCaseResults.values()) {
            if (result) {
                total += 10;
            }
        }
        this.score = total;
    }

    public String getName() {
        return name;
    }

    public int getSubmissionTime() {
        return submissionTime;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Score: " + score + 
               " | Submission Time: " + submissionTime;
    }
}
