import java.util.*;

public class leapYear_by_ifElse {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int year = sc.nextInt();

    //checking gregorian calendar condition
    if(year<1582){
      System.out.println("Year must be 1582 or later");
    }

    else{
      if(year%400==0){
        System.out.println("Year is a Leap Year");
      }
      else if(year%4==0){
        System.out.println("Year is a Leap Year");
      }

      else if(year%100==0){
        System.out.println("Year is not a Leap Year");
      }

      else{
        System.out.println("Year is not a Leap Year");
      }
    }

    sc.close();
  }
}
