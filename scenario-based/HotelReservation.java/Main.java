public class Main {

    public static void main(String[] args) {

        Hotel hotel = new Hotel();

        hotel.addRoom(new StandardRoom(101));
        hotel.addRoom(new DeluxeRoom(201));

        Guest guest = new Guest(1, "Priyank");

        PricingStrategy pricing = new SeasonalPricing();
        // PricingStrategy pricing = new RegularPricing();

        Room room = hotel.findAvailableRoom();

        if (room == null) {
            System.out.println("No rooms available");
            return;
        }

        Reservation reservation = new Reservation(room, guest, 3, pricing);

        try {
            reservation.checkIn();
            reservation.generateInvoice();
            reservation.checkOut();
        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
