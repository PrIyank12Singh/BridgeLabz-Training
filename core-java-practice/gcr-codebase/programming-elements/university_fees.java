public class university_fees {
  public static void main(String[] args) {
    int fee = 125000;

    int discount_p = 10;
    int discount = (fee * discount_p)/100;

    int final_fees = fee- discount;

    System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+final_fees);
  }
}
