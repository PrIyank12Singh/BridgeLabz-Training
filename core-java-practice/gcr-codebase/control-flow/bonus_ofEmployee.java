import java.util.*;

public class bonus_ofEmployee {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input

    int salary = sc.nextInt();
    int years = sc.nextInt();

    if(years>=5){
      System.out.println("Bonus is INR "+salary*0.5);
    }

    else if(years <5){
      System.out.println("No Bonus");
    }
    sc.close();
  }
}
