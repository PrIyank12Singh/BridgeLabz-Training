import java.util.*;
public class area_of_triangle {
  public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);
    //Input base and height in inches
    double base = sc.nextDouble();

    double height = sc.nextDouble();

    //Area in square inches 
    double area_inches = 0.5 * base * height;

    //conversion from square inches to centimeters
    double area_cm = area_inches *  6.4516;

    //Output
    System.out.println(
            "Area in square inches: " + area_inches +
            " and in square centimeters: " + area_cm
        );



    sc.close();
  }
}
