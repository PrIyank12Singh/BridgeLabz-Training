import java.util.*;

public class total_price {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //Taking input
    
    double unitPrice = sc.nextDouble();            //taking unit's Price

    int quantity = sc.nextInt();                    //taking quantity that we want of particular unit

    double total_price = unitPrice * quantity;       //calculating total price

    System.out.println("The total purchase price is INR " + total_price+ " if the quantity " +quantity+ " and unit price is INR "+unitPrice);
    sc.close();
  }  
}
