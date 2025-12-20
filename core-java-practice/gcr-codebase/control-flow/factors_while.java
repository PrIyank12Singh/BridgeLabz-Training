import java.util.*;

public class factors_while {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    if(n<=0){
      System.out.println("Invalid Input");
    }

    else if(n>0){
      int i=1;
      while(i<n){
        if(n%i==0){
          System.out.println(i+ " is the factor of "+n);
        }
        i++;
      }
    }
    sc.close();
  }
}
