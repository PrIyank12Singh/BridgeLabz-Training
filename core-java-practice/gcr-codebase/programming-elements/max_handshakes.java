import java.util.*;
public class max_handshakes {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();                        //taking n as a input

    int max_Handshakes = (n*(n-1))/2;           //formula to calculate max possible handshakes

    System.out.println(max_Handshakes);

    sc.close();
  }
}
