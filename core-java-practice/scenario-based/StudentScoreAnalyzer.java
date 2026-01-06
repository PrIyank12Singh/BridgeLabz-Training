

// custom exception
class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}

public class StudentScoreAnalyzer {

    // validate scores
    public static void validateScores(int[] scores) throws InvalidScoreException {
        for (int score : scores) {
            if (score < 0 || score > 100) {
                throw new InvalidScoreException("Invalid score found: " + score);
            }
        }
    }


    //method for Calculating Average
    public static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int s : scores) {
            sum += s;
        }
        return (double) sum / scores.length;
    }

    public static int findMax(int[] scores) {
        int max = scores[0];
        for (int s : scores) {
            if (s > max) max = s;
        }
        return max;
    }

    //Method for Finding Minimum 
    public static int findMin(int[] scores) {
        int min = scores[0];
        for (int s : scores) {
            if (s < min) min = s;
        }
        return min;
    }

    public static void main(String[] args) {

        int[] scores = {78, 85, 90, 66, 88};

        try {
            validateScores(scores);

            System.out.println("Average Score: " + calculateAverage(scores));
            System.out.println("Highest Score: " + findMax(scores));
            System.out.println("Lowest Score: " + findMin(scores));

        } catch (InvalidScoreException e) {
            System.out.println(e.getMessage());
        }
    }
}
