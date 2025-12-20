import java.util.*;

public class sum_until_0 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    double total = 0.0;

    double value = sc.nextDouble();

    //while loop checks if value is not 0
    while(value!=0){
      total+=value;  //adding in total value

      System.out.print("Enter a number(0 to stop): ");
      value = sc.nextDouble();
    }

    System.out.println("The total value is= "+total);
    sc.close();
  }
}
