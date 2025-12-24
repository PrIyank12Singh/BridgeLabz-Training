
import java.util.*;
public class Simple_Interest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input
    int p = sc.nextInt();
    int r = sc.nextInt();
    int t  = sc.nextInt();

    int si = (p*r*t)/100;

    System.out.println(si);

    sc.close();
  }  
}
