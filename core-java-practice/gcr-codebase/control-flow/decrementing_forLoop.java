import java.util.*;

public class decrementing_forLoop {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    //Taking input
    int n = sc.nextInt();

    //decrementing value by for loop
    for(int i=n;i>=1;i--){
      System.out.println("Countdown = "+i);
    }

    sc.close();
  }
}
