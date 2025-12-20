import java.util.*;

public class multiply_from_6to9 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //taking input
    int input = sc.nextInt();
    
    //define array to store results 
    int[] multiplicationResult = new int[4];

    //store multiplication from 6 to 9
    int index = 0;
    for (int i = 6; i <=9 ; i++) {
      multiplicationResult[index] =  input * i;
      index++; 

      
    }

    //display result 
    index = 0;
    for (int i = 6; i <= 9; i++) {
      System.out.println(input + " * "+i+" = "+multiplicationResult[index]);
    }
    sc.close();
  }
}
