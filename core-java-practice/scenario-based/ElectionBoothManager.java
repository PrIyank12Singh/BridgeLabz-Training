import java.util.Scanner;

public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int vote;
        int countA = 0, countB = 0, countC = 0;

        while (true) {
            System.out.print("Enter age (or -1 to stop): ");
            int age = input.nextInt();

            // Exit condition
            if (age == -1) {
                break;
            }

            // Eligibility check
            if (age >= 18) {
                System.out.println("Eligible to vote");
                System.out.print("Vote (1-A, 2-B, 3-C): ");
                vote = input.nextInt();

                if (vote == 1) {
                    countA++;
                } else if (vote == 2) {
                    countB++;
                } else if (vote == 3) {
                    countC++;
                } else {
                    System.out.println("Invalid vote");
                }
            } else {
                System.out.println("Not eligible to vote");
            }
        }

        // Final Result
        System.out.println("\n--- Voting Result ---");
        System.out.println("Candidate A: " + countA);
        System.out.println("Candidate B: " + countB);
        System.out.println("Candidate C: " + countC);

        input.close();
    }
}
