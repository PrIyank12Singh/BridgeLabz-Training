import java.util.Scanner;

public class Area_of_Circle {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input
    int r = sc.nextInt();
    
    double area = 3.14 * r * r;

    System.out.println(area);

    sc.close();
  }
}
