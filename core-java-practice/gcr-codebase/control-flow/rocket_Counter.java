import java.util.*;

public class rocket_Counter {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input
    int n = sc.nextInt();

    int i=n;

    //decrementing counter and printing it

    while(i>=1){
      int j = i--;
      System.out.println("Countdown = "+j);
    }

    
    sc.close();
  }  
}
