class Ticket {
    int ticketId;
    String eventName;
    double price;

    public Ticket(int ticketId, String eventName, double price) {
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.price = price;
    }

    public void display() {
        System.out.println(ticketId + " | " + eventName + " | ₹" + price);
    }
}
