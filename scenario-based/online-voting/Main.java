public class Main {

    public static void main(String[] args) {

        ElectionService election = new ElectionSystem();

        election.registerVoter(new Voter(1, "Priyank"));
        election.registerVoter(new Voter(2, "Amit"));

        election.addCandidate(new Candidate(101, "Alice"));
        election.addCandidate(new Candidate(102, "Bob"));

        try {
            election.castVote(1, 101);
            election.castVote(2, 102);
            election.castVote(1, 102); // duplicate vote
        } catch (DuplicateVoteException e) {
            System.out.println(e.getMessage());
        }

        election.declareResults();
    }
}
