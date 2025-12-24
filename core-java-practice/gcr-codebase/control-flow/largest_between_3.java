import java.util.*;

public class largest_between_3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input
    //Taking input of 3 numbers

    int number1 = sc.nextInt();
    int number2 = sc.nextInt();
    int number3 = sc.nextInt();


    //checking which one is larger between 3 
    boolean is_First_Largest = number1>number2 && number1>number3;
    boolean is_Second_Largest = number2>number1 && number2>number3;
    boolean is_Third_Largest = number3>number1 && number3>number2;

    //printing the statements
    System.out.println("Is the first number the largest? "+is_First_Largest);
    System.out.println("Is the second number the largest? "+is_Second_Largest);
    System.out.println("Is the third number the largest? "+is_Third_Largest);



    sc.close();
  }
}
