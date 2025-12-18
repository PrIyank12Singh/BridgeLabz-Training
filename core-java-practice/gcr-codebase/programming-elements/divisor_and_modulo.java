import java.util.*;

public class divisor_and_modulo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int number1 = sc.nextInt();
    int number2 = sc.nextInt();

    int division_of_nums = number1/number2;
    
    int moduli_of_nums = number1%number2;

    System.out.println("The Quotient is " +division_of_nums+" and Reminder is "+moduli_of_nums+ " of two number "+number1+"and"+number2);
    sc.close();
  }  
}
