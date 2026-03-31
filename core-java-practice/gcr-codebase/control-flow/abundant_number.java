import java.util.*;

public class abundant_number {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking n as a input
    int n= sc.nextInt();

    int sum = 0;

    for (int i = 1; i < n; i++) {
      if(n%i==0){
        sum+=i;
      }
    }

    if(sum>n){
      System.out.println(n+" is a Abundant Number");
    }

    else{
      System.out.println(n+" is not a Abundant Number");
    }
    sc.close();
  }
}
