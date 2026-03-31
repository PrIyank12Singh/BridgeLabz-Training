public class ElectionSystem implements ElectionService {

    private Voter[] voters;
    private Candidate[] candidates;
    private Vote[] votes;

    private int voterCount;
    private int candidateCount;
    private int voteCount;

    public ElectionSystem() {
        voters = new Voter[10];
        candidates = new Candidate[10];
        votes = new Vote[50];
        voterCount = 0;
        candidateCount = 0;
        voteCount = 0;
    }

    public void registerVoter(Voter voter) {
        voters[voterCount++] = voter;
        System.out.println("Voter registered: " + voter.getName());
    }

    public void addCandidate(Candidate candidate) {
        candidates[candidateCount++] = candidate;
        System.out.println("Candidate added: " + candidate.getName());
    }

    public void castVote(int voterId, int candidateId) throws DuplicateVoteException {

        Voter voter = findVoter(voterId);
        Candidate candidate = findCandidate(candidateId);

        if (voter == null || candidate == null) {
            System.out.println("Invalid voter or candidate");
            return;
        }

        if (voter.hasVoted()) {
            throw new DuplicateVoteException("Voter has already voted");
        }

        voter.markVoted();
        candidate.addVote();
        votes[voteCount++] = new Vote(voterId, candidateId);

        System.out.println("Vote cast by " + voter.getName());
    }

    public void declareResults() {
        System.out.println("Election Results:");
        for (int i = 0; i < candidateCount; i++) {
            System.out.println(
                candidates[i].getName() + " -> " + candidates[i].getVotes() + " votes"
            );
        }
    }

    private Voter findVoter(int id) {
        for (int i = 0; i < voterCount; i++) {
            if (voters[i].getId() == id) {
                return voters[i];
            }
        }
        return null;
    }

    private Candidate findCandidate(int id) {
        for (int i = 0; i < candidateCount; i++) {
            if (candidates[i].getId() == id) {
                return candidates[i];
            }
        }
        return null;
    }
}
