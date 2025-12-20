import java.util.*;

public class sumuntil0_or_negative {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    double total = 0.0;

    double value = sc.nextDouble();

    //while loop checks if value is not 0
    while(true){
      System.out.print("Enter a number (0 or negative to stop): ");
      value = sc.nextDouble();

      
      //check for 0 or negative number
      if(value<=0){
        break;
      }
      
      total+=value;  //adding in total value
      
      
    }

    System.out.println("The total value is= "+total);


    sc.close();
  }
}
