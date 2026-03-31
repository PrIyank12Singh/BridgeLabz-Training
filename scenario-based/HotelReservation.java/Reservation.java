public class Reservation {

    private Room room;
    private Guest guest;
    private int days;
    private PricingStrategy pricingStrategy;

    public Reservation(Room room, Guest guest, int days, PricingStrategy pricingStrategy) {
        this.room = room;
        this.guest = guest;
        this.days = days;
        this.pricingStrategy = pricingStrategy;
    }

    public void checkIn() throws RoomNotAvailableException {
        if (!room.isAvailable()) {
            throw new RoomNotAvailableException("Room is not available");
        }
        room.book();
        System.out.println("Checked in: " + guest.getName());
    }

    public void checkOut() {
        room.checkout();
        System.out.println("Checked out: " + guest.getName());
    }

    public void generateInvoice() {
        double total = pricingStrategy.calculatePrice(room.getPricePerDay(), days);
        System.out.println("Invoice for " + guest.getName());
        System.out.println("Room: " + room.getRoomNumber());
        System.out.println("Days: " + days);
        System.out.println("Total Amount: " + total);
    }
}
