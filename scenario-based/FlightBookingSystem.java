import java.util.*;

class Flight {
    String flightNo;
    String source;
    String destination;

    public Flight(String flightNo, String source, String destination) {
        this.flightNo = flightNo;
        this.source = source;
        this.destination = destination;
    }
}

public class FlightBookingSystem {

    static Flight[] flights = {
        new Flight("AI101", "Delhi", "Mumbai"),
        new Flight("AI202", "Delhi", "Bangalore"),
        new Flight("AI303", "Mumbai", "Chennai")
    };

    static List<Flight> bookings = new ArrayList<>();

    static void searchFlight(String source, String destination) {
        for (Flight f : flights) {
            if (f.source.equalsIgnoreCase(source) &&
                f.destination.equalsIgnoreCase(destination)) {
                System.out.println("Flight Found: " + f.flightNo);
                return;
            }
        }
        System.out.println("No Flight Found");
    }

    static void bookFlight(String flightNo) {
        for (Flight f : flights) {
            if (f.flightNo.equalsIgnoreCase(flightNo)) {
                bookings.add(f);
                System.out.println("Flight Booked: " + flightNo);
                return;
            }
        }
        System.out.println("Invalid Flight Number");
    }

    static void showBookings() {
        System.out.println("Your Bookings:");
        for (Flight f : bookings) {
            System.out.println(f.flightNo + " " + f.source + " → " + f.destination);
        }
    }

    public static void main(String[] args) {
        searchFlight("Delhi", "Mumbai");
        bookFlight("AI101");
        showBookings();
    }
}
