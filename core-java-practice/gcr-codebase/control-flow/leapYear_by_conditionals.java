import java.util.*;

public class leapYear_by_conditionals {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //Taking input
    int year = sc.nextInt();

    if(year>=1582 && (year%400==0 ||(year%4==0 && year%100!=0))){
      System.out.println("Year is a Leap Year");
    }

    else{
      System.out.println("Year is not a Leap Year");
    }

    sc.close();
  }
}
