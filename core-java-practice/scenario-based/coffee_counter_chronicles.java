import java.util.*;

public class coffee_counter_chronicles {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final double GST_rate = 0.18; //18% GST

    while (true) {
      String coffee_type = sc.next();       //taking input of coffee type 

      if(coffee_type.equalsIgnoreCase("exit")){
        System.out.println("Cafe closed. Thank You!");
        break;
      }

      int quantity = sc.nextInt();           //taking input of quantity

      double price = 0;

      switch (coffee_type.toLowerCase()) {
        case "espresso":
          price = 150;
          break;

        case "latte":
          price = 180;
          break;
        
        case "cappuccino":
          price = 220;
          break;

        default:
          System.out.println("Invalid Coffee Type!");
          continue;
      }

      //calculating bill, gst and total amount
      double bill = price*quantity;
      double gst = bill* GST_rate;
      double total_amount = bill+gst;



      System.out.println("Bill Amount: INR "+bill);
      System.out.println("GST (18%): INR "+gst);
      System.out.println("Total Payable Amount: INR "+total_amount);
      

    }
    sc.close();
  }
}
