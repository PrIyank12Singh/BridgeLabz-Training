public class VotingSystemApp {

    public static void main(String[] args) {

        VotingSystem system = new VotingSystem();

        // Simulate voting
        system.vote("Alice");
        system.vote("Bob");
        system.vote("Alice");
        system.vote("Carol");
        system.vote("Bob");
        system.vote("Alice");

        // Display results
        System.out.println("----- Voting Results -----");
        system.displayAllVotes();
        system.displayInsertionOrderResults();
        system.displaySortedResults();
    }
}
