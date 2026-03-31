import java.util.*;

public class comparing_using_for {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //Taking input
    int n = sc.nextInt();

    if(n<0){
      System.out.println("Invalid Input");
    }

    else if(n>0){
      int sum1 = (n*(n+1))/2;

      int sum2= 0;



      for(int i=1;i<=n;i++){
        sum2+=i;
      }

      

      if(sum1==sum2){
        System.out.println("Yes both sums are same");
      }

      else if(sum1!=sum2){
        System.out.println("No both sums are different");
      }

      }

    
    sc.close();
  }
}
