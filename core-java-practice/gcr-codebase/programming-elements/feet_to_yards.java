import java.util.*;
public class feet_to_yards {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //Taking input
    int distance_feet = sc.nextInt();               //taking input in feet

    int distance_yard = distance_feet /3;          //formula to calculate in yards from feet


    int distance_mile = distance_yard/1760;          //formula to calculate in miles from yards

    System.out.println("The distance is feet is "+distance_feet+" while in yards is "+distance_yard+" and miles is "+distance_mile);
    sc.close();
  }
}
