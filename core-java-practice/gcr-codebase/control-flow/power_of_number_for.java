import java.util.*;

public class power_of_number_for {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //Taking input
    int n = sc.nextInt();

    int pow = sc.nextInt();

    int result = 1;

    for(int i=1;i<=pow;i++){
      result *= n;
    }

    System.out.println("Result = "+result);
    sc.close();
  }
}
