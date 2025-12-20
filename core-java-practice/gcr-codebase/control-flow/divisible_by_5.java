import java.util.*;

public class divisible_by_5 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //taking any number as input
    int number = sc.nextInt();

    //checking whether number is divisible by 5 or not
    if(number%5==0){
      System.out.println("Is the number "+number+" divisible by 5? Yes");
    }

    else if(number%5!=0){
      System.out.println("Is the number "+number+" divisible by 5? No");
    }

    sc.close();
  }
}
