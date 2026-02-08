public class AuctionSystemTest {
    public static void main(String[] args) {
        AuctionItem item = new AuctionItem("iPhone 15");

        User u1 = new User("Alice");
        User u2 = new User("Bob");
        User u3 = new User("Charlie");

        try {
            item.placeBid(u1, new Bid(500));
            item.placeBid(u2, new Bid(600));
            item.placeBid(u3, new Bid(550)); // will throw InvalidBidException
        } catch (InvalidBidException e) {
            System.out.println("Error: " + e.getMessage());
        }

        item.showAllBids();
    }
}
