import java.util.*;

public class greatestfactor_while {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input
    int n = sc.nextInt();

    int greatestfactor = 1;

    int i=n-1;
    while(i>=1){
      if(n%i==0){
        greatestfactor=i;
        break;
      }
      i--;
    }

    System.out.println("Greatest factor is: "+greatestfactor);
    sc.close();
  }
}
