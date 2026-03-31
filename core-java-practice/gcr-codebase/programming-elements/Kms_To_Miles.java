import java.util.*;

public class Kms_To_Miles {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input
    int kms = sc.nextInt();

    double miles = kms * 0.621371;

    System.out.println(miles);

    sc.close();
  }
}
