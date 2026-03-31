import java.util.*;

public class odd_or_even {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //Taking input
    int n = sc.nextInt();

    if(n<1){
      System.out.println("Not a natural number");
    }

    else if(n>=1){
        for(int i=1;i<=n;i++){
          if(i%2==0){
            System.out.println(i+" is even");
          }

          else if(i%2!=0){
            System.out.println(i+" is odd");
          }
        }
    }

    



    sc.close();
  }
}
