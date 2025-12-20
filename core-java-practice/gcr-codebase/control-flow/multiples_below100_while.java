import java.util.*;

public class multiples_below100_while {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    if(n>0 && n<100){
      int i=100;
      while(i>=1){
        if(i%n==0){
          System.out.println(i);
        }
        i--;
      }
    }

    else{
      System.out.println("Invalid Input");
    }

    sc.close();
  } 
}
