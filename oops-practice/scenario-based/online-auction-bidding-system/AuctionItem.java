import java.util.Map;
import java.util.TreeMap;

class AuctionItem {
    private String itemName;
    private TreeMap<User, Bid> bids;

    public AuctionItem(String itemName) {
        this.itemName = itemName;
        this.bids = new TreeMap<>();
    }

    public void placeBid(User user, Bid bid) throws InvalidBidException {
        double highestBid = getHighestBidAmount();
        if (bid.getAmount() <= highestBid) {
            throw new InvalidBidException("Bid must be higher than current highest bid: " + highestBid);
        }
        bids.put(user, bid);
        System.out.println(user.getName() + " placed a bid of $" + bid.getAmount());
    }

    public double getHighestBidAmount() {
        double max = 0;
        for (Bid bid : bids.values()) {
            if (bid.getAmount() > max) {
                max = bid.getAmount();
            }
        }
        return max;
    }

    public User getHighestBidder() {
        double max = 0;
        User highestBidder = null;
        for (Map.Entry<User, Bid> entry : bids.entrySet()) {
            if (entry.getValue().getAmount() > max) {
                max = entry.getValue().getAmount();
                highestBidder = entry.getKey();
            }
        }
        return highestBidder;
    }

    public void showAllBids() {
        System.out.println("All bids for " + itemName + ":");
        for (Map.Entry<User, Bid> entry : bids.entrySet()) {
            System.out.println(entry.getKey().getName() + " => $" + entry.getValue().getAmount());
        }
        System.out.println("Highest Bid: $" + getHighestBidAmount() + " by " + getHighestBidder());
    }
}
