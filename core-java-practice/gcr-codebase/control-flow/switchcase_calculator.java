import java.util.*;

public class switchcase_calculator {
  public static void main(String[] args) {
    Scanner sc = new  Scanner(System.in);
    //Taking input
    double num1 = sc.nextDouble();
    double num2 = sc.nextDouble();

    String op = sc.next();

    double result;

    switch (op) {
      case "+":
        result = num1+num2;
        System.out.println("Result = "+result);
        break;
      
      case "-":
        result = num1-num2;
        System.out.println("Result = "+result);
        break;  
      
      case "*":
        result = num1*num2;
        System.out.println("Result = "+result);
        break;

      case "/":
        if(num2!=0){
          result = num1/num2;
          System.out.println("Result = "+result);

        }

        else{
          System.out.println("Division by 0 is not allowed");
        }
        break;

      default:
        System.out.println("Invalid Operator");
        
    }

    sc.close();
  }
}
