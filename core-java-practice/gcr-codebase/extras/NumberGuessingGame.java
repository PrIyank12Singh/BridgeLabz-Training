import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    static int generateGuess(int low, int high) {
        return new Random().nextInt(high - low + 1) + low;
    }

    static String getFeedback(Scanner sc) {
        System.out.print("Is it High, Low, or Correct? (h/l/c): ");
        return sc.next();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int low = 1, high = 100;
        System.out.println("Think of a number between 1 and 100");

        while (true) {
            int guess = generateGuess(low, high);
            System.out.println("Computer guess: " + guess);

            String feedback = getFeedback(sc);

            if (feedback.equals("c")) {
                System.out.println("Computer guessed correctly!");
                break;
            } else if (feedback.equals("h")) {
                high = guess - 1;
            } else if (feedback.equals("l")) {
                low = guess + 1;
            }
        }

        sc.close();
    }
}
