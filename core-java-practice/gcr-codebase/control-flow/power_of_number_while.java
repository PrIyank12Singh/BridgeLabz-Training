import java.util.*;

public class power_of_number_while {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int pow = sc.nextInt();

    int result = 1;

    int i=1;
    while(i<=pow){
      result *= n;
      i++;
    }

    System.out.println("Result = "+result);
    sc.close();
  }
}
