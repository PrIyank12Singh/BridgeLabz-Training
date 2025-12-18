import java.util.*;

public class side_from_perimeter {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);    
    double perimeter = sc.nextDouble();           //Taking perimeter of square

    //As perimeter of square is 4*side , so like this we can find side of square
    double side = perimeter/4;

    System.out.println("The length of side is " + side + "whose perimeter is "+perimeter);
    sc.close();
  }
}
