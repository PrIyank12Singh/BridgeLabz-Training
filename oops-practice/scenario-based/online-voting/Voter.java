public class Voter {
    private int id;
    private String name;
    private boolean hasVoted;

    public Voter(int id, String name) {
        this.id = id;
        this.name = name;
        this.hasVoted = false;
    }

    public int getId() {
        return id;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void markVoted() {
        hasVoted = true;
    }

    public String getName() {
        return name;
    }
}
