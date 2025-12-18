public class volume_of_earth {
  public static void main(String[] args) {
    int radius_km = 6378;

    double r_m = 6378 * 0.621371;

    double volume_km = (4*3.14*Math.pow(radius_km,3))/3;
    double volume_m = (4*3.14* Math.pow(r_m, 3))/3;

    System.out.println("The volume of earth in cubic kilometers is "+volume_km+" and cubic meters is "+volume_m);
  }
  
}
