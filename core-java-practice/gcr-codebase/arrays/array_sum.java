import java.util.*;

public class array_sum {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    //declare array and variables 
    double[] arr = new double[10];
    double total = 0.0;
    int index = 0;

    //Infinite while loop
    while (true) {

      double num = sc.nextDouble();

      //break if number is 0 or negative 
      if (num<=0) {
        break;
      }

      //break if array size reaches 10
      if (index == 10) {
        break;
      }

      //Store value and increment index
      arr[index] = num;
      index++;
    }

    //display number and calculate sum
    for (int i = 0; i < index; i++) {
      System.out.println(arr[i]);
      total += arr[i];
    }

    //display total
    System.out.println("\nSum of all number = "+total);
    sc.close();
  }
}
