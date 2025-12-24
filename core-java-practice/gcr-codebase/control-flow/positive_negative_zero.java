import java.util.*;

public class positive_negative_zero {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    //Taking input
    int number = sc.nextInt();

    //checking  number
    if(number<0){
      System.out.println("The number is negative");

    }

    else if(number>0){
      System.out.println("The number is positive");
    }

    else if(number==0){
      System.out.println("The number is zero");
    }

    sc.close();
  }
}
