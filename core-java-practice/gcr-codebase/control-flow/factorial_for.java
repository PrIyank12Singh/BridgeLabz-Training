import java.util.*;

public class factorial_for {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    //Taking input
    int n = sc.nextInt();

    if(n<0){
      System.out.println("Invalid Input");

    }

    else if(n==0){
      System.out.println("Factorial of 0 is 1");
    }

    else if(n>0){
      int fact = 1;

      for(int i=1;i<=n;i++){
        fact *= i;
      }
      System.out.println("Factorial of "+n+" is "+fact);
    }

    
    sc.close();
  }
}
