import java.util.*;
public class conversion_of_height {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double centimeters = sc.nextInt();

    double inches = centimeters/2.54;

    int feet = (int)(inches/12);

    int remaining_inches = (int)(inches%12);

    System.out.println("Your Height in cm is  "+centimeters+" while in feet is "+feet+" and inches is "+ remaining_inches);

    sc.close();
  }
}
