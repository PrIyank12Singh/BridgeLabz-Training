import java.util.*;

public class comparing_sums {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    if(n<0){
      System.out.println("Invalid Input");
    }

    else if(n>0){
      int sum1 = (n*(n+1))/2;

      int sum2= 0;

      int i=1;

      while(i<=n){
        sum2+=i;
        i++;
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
