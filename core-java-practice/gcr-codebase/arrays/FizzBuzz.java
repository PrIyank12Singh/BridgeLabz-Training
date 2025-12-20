import java.util.*;

public class FizzBuzz {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();

    if (num<=0) {
      System.out.println("Invalid Input");
    }

    //creating string array
    String[] result = new String[num+1];

    //loop from 0 to num and save values
    for (int i = 0; i <= num; i++) {
      if (i%3==0 && i%5==0) {
        result[i] = "FizzBuzz";
      }

      else if (i%3==0) {
        result[i] = "Fizz";
      }

      else if (i%5==0) {
        result[i] ="Buzz";
      }

      else{
        result[i] = String.valueOf(i);
      }
    }

    //print array results with position 

    for (int i = 0; i <=num; i++) {
      System.out.println("Position "+i+" = "+result[i]);
    }



    sc.close();
  }
}