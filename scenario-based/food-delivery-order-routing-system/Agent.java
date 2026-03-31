class Agent {
    private int agentId;
    private String agentName;
    private String location;
    private boolean available;

    public Agent(int agentId, String agentName, String location) {
        this.agentId = agentId;
        this.agentName = agentName;
        this.location = location;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getLocation() {
        return location;
    }

    public void assignOrder() {
        this.available = false;
    }

    public void completeOrder() {
        this.available = true;
    }

    @Override
    public String toString() {
        return "Agent ID: " + agentId +
                ", Name: " + agentName +
                ", Location: " + location +
                ", Available: " + available;
    }
}
