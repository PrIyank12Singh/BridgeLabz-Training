import java.util.List;
import java.util.Scanner;

public class HackathonRunner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HackathonManager manager = new HackathonManager();

        System.out.print("Enter number of participants: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter participant name:");
            String name = sc.nextLine();

            System.out.println("Enter submission time (minutes):");
            int time = sc.nextInt();
            sc.nextLine();

            ParticipantEntry participant =
                    new ParticipantEntry(name, time);

            System.out.println("Enter number of questions attempted:");
            int q = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < q; j++) {

                System.out.println("Enter Question ID:");
                String qId = sc.nextLine();

                System.out.println("Did test case pass? (true/false)");
                boolean result = sc.nextBoolean();
                sc.nextLine();

                participant.addTestCaseResult(qId, result);
            }

            try {
                manager.addParticipant(participant);
            } catch (LateSubmissionException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\n===== LEADERBOARD =====");

        List<ParticipantEntry> leaderboard = manager.getLeaderboard();

        int rank = 1;
        for (ParticipantEntry p : leaderboard) {
            System.out.println(rank + ". " + p);
            rank++;
        }

        sc.close();
    }
}
