import java.util.*;
public class Convert_distance_to_miles {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input
    

    double km = sc.nextDouble();

    double miles = km * 0.621371;

    System.out.println("Distance in kilometers is "+km+" in miles is"+ miles);
    sc.close();
  }
  
}
