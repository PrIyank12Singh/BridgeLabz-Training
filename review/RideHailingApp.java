package review;
public class RideHailingApp {
    //Abstract Class Ride
    static abstract class Ride {

        double distanceKm;
        double fare;

        public Ride(double distanceKm) {
            this.distanceKm = distanceKm;
        }
        public void calculateFare() {
            this.fare = baseFare()+(distanceKm*perKmRate());
        }

        protected abstract double baseFare();
        protected abstract double perKmRate();

        //encapsulating fare and distance calculation
        public double getFare() {
            return fare;
        }

        public double getDistanceKm() {
            return distanceKm;
        }
    }

    //Here BikeRide extends Ride

    static class BikeRide extends Ride {
        public BikeRide(double distanceKm) {
            super(distanceKm);
        }

        protected double baseFare() {
            return 20;
        }

        protected double perKmRate() {
            return 5;
        }
    }

    static class MiniRide extends Ride {
        public MiniRide(double distanceKm) {
            super(distanceKm);
        }

        protected double baseFare() {
            return 40;
        }

        protected double perKmRate() {
            return 10;
        }
    }

    static class SedanRide extends Ride{
      public SedanRide(double distanceKm){
        super(distanceKm);
      }

      protected double baseFare(){
        return 60;
      }

      protected double perKmRate(){
        return 15;
      }
    }

    static class SuvRide extends Ride{
      public SuvRide(double distanceKm){
        super(distanceKm);
      }

      protected double baseFare(){
        return 80;
      }

      protected double perKmRate(){
        return 20;
      }
    }

    // static class of booking service

    static class BookingService {

        public static Ride bookRide(String type, double distance) {

            Ride ride;

            switch (type.toLowerCase()) {
                case "bike":
                    ride = new BikeRide(distance);
                    break;
                case "mini":
                    ride = new MiniRide(distance);
                    break;
                case "sedan":
                    ride = new SedanRide(distance);
                    break;
                case "suv":
                    ride = new SuvRide(distance);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid ride type");
            }

            ride.calculateFare(); //runtime polymorphism
            return ride;
        }
    }

    //Main class

    public static void main(String[] args) {

        Ride r1 = BookingService.bookRide("bike", 10);
        Ride r2 = BookingService.bookRide("mini", 10);
        Ride r3 = BookingService.bookRide("sedan", 10);
        Ride r4 = BookingService.bookRide("suv", 10);

        //printing ride rate and calculating base fare
        printRide(r1);
        printRide(r2);
        printRide(r3);
        printRide(r4);

    }

    static void printRide(Ride ride) {
        System.out.println(
                ride.getClass().getSimpleName() +
                " | Distance: " + ride.getDistanceKm() +
                " kilometers | Fare: INR " + ride.getFare()
        );
    }
  }
