import java.util.*;

public class factors_for {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input
    int n = sc.nextInt();

    if(n<=0){
      System.out.println("Invalid Input");
    }

    else if(n>0){
      for(int i=1;i<n;i++){
        if(n%i==0){
          System.out.println(i+ " is the factor of "+n);
        }
      }
    }
    sc.close();
  }
}
