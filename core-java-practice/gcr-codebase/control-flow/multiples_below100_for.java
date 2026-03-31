import java.util.*;

public class multiples_below100_for {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //Taking input
    int n = sc.nextInt();

    if(n>0 && n<100){
      for(int i=100;i>=1;i--){
        if(i%n==0){
          System.out.println(i);
        }
      }
    }

    else{
      System.out.println("Invalid Input");
    }

    sc.close();
  }
}
