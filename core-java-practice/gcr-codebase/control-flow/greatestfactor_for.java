import java.util.*;

public class greatestfactor_for {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input
    int n = sc.nextInt();

    int greatestfactor = 1;

    for(int i=n-1;i>=1;i--){
      if(n%i==0){
        greatestfactor=i;
        break;
      }
    }

    System.out.println("Greatest factor is: "+greatestfactor);
    sc.close();
  }
}
