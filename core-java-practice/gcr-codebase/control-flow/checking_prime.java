import java.util.*;

public class checking_prime {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    boolean isPrime = true;

    if(n<=1){
      isPrime = false;
    }

    else{
      
      //checking divisibility from 2 to n-1

      for (int i = 2; i < n; i++) {
        if(n%i==0){
          isPrime = false;
          break;
        }
      }
    }

    if (isPrime == true) {
      System.out.println(n+" is a Prime Number");
    }

    else{
      System.out.println(n+" is not a Prime Number");
    }
    sc.close();
  }
}
