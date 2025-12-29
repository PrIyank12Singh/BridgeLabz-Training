import java.util.Scanner;

public class MovieTicketBooking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int customer = 1; customer <= 3; customer++) {
            System.out.println("\nCustomer " + customer);

            //select movie type
            String movieType = input.next();

            //select seat type
            String seatType = input.next();

            //select whether viewer wants snack or not
            String snacks = input.next();

            int price = 0;

            // switch + if together
            switch (movieType) {
                case "2D":
                    price = seatType.equalsIgnoreCase("Gold") ? 200 : 150;
                    break;
                case "3D":
                    price = seatType.equalsIgnoreCase("Gold") ? 300 : 250;
                    break;
                default:
                    System.out.println("Invalid movie type");
            }

            if (snacks.equalsIgnoreCase("yes")) {
                price += 100;
            }

            System.out.println("Total Ticket Price: ₹" + price);
        }

        input.close();
    }
}
