class MovieTicket {

    // attributes
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked = false;

    // method to book ticket
    void bookTicket(String movie, String seat, double ticketPrice) {
        if (!isBooked) {
            movieName = movie;
            seatNumber = seat;
            price = ticketPrice;
            isBooked = true;

            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }

    // method to display ticket details
    void displayTicket() {
        if (!isBooked) {
            System.out.println("Ticket have not booked yet....");
        } else {
            System.out.println("Price: $" + price);
            System.out.println();
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }

    // main method
    public static void main(String[] args) {

        MovieTicket tick = new MovieTicket();

        tick.displayTicket();
        tick.bookTicket("Dragon", "A10", 120);
        tick.bookTicket("Dragon", "A10", 120);
        tick.bookTicket("Dragon", "A10", 120);
        tick.displayTicket();
    }
}
