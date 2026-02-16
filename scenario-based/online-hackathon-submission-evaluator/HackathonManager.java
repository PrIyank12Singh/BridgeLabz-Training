import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HackathonManager {

    private static final int DEADLINE = 60;
    private List<ParticipantEntry> participants = new ArrayList<>();

    public void addParticipant(ParticipantEntry participant)
            throws LateSubmissionException {

        if (participant.getSubmissionTime() > DEADLINE) {
            throw new LateSubmissionException("Submission after deadline!");
        }

        participant.calculateScore();
        participants.add(participant);
    }

    public List<ParticipantEntry> getLeaderboard() {

        participants.sort(new Comparator<ParticipantEntry>() {
            @Override
            public int compare(ParticipantEntry p1, ParticipantEntry p2) {
                return p2.getScore() - p1.getScore();
            }
        });

        return participants;
    }
}
