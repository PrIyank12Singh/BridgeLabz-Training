import java.util.Scanner;

public class BusRouteDistanceTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

  

        int totalDistance = 0;
        char choice = 'n';

        

        while (choice != 'y') {

          //taking distance as input
            int distance = sc.nextInt();

            //calculating total distance

            totalDistance = totalDistance + distance;

            System.out.print("Do you want to get off at this stop? (y/n): ");
            choice = sc.next().charAt(0);
        }

        //printing has passenger got off

        System.out.println("Passenger got off.");

        //printing total distance travelled by passenger
        System.out.println("Total distance travelled: " + totalDistance + " km");

        sc.close();
    }
}
