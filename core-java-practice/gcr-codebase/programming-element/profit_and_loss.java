public class profit_and_loss {
  public static void main(String[] args) {
    int cp = 129;
    int sp = 191;
    int p = sp-cp;

    double profit_p = (p*100)/cp;

    System.out.println(
    "The Cost Price is INR " + cp + 
    " and Selling Price is INR " + sp + "\n" +
    "The Profit is INR " + p + 
    " and the Profit Percentage is " + profit_p + "%"
);


  }
}
