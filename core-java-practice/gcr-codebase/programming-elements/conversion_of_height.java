import java.util.*;
public class conversion_of_height {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);   //Scanner is taken for input
    //Taking input
    double centimeters = sc.nextInt();  //Input for centimeters 

    double inches = centimeters/2.54;   //Calculation of inches

    double feet = (inches/12);  //Calculation of feet from inches

    

    System.out.println("Your Height in cm is  "+centimeters+" while in feet is "+feet+" and inches is "+ inches);

    sc.close();
  }
}
