import java.util.*;
public class basic_arithmetic {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //Taking input

    float number1 = sc.nextFloat();   //taking number1 as input 
    float number2 = sc.nextFloat();   //taking number2 as input 

    float addition = number1+number2;   //adding both numbers
    
    float subtract = number1-number2;  //subtracting both numbers

    float multiply = number1*number2;  //multiplying both numbers

    float division = number1/number2;   //dividing both numbers

    System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+number1+" and "+number2+" is "+addition+","+subtract+","+multiply+" and "+division);

    

    

    System.out.println();

    sc.close();
  }
}
