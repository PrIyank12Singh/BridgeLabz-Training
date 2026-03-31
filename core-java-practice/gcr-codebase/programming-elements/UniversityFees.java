import java.util.*;

public class UniversityFees {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input
    int fee = sc.nextInt();

    int  discount_p = sc.nextInt();
    int discount = (fee * discount_p)/100;

    int final_fees = fee- discount;

    System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+final_fees);

    sc.close();
  }
}
