import java.util.*;

class Age_calculator{
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int birthYear = 2000;
      int currentYear = sc.nextInt();
      int age = currentYear - birthYear;

      System.out.println("Harry's age in "+currentYear+" is: " +age);
      sc.close(); 
  }
}