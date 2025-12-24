import java.util.*;

public class odd_and_even {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    
    int n = sc.nextInt();

    if (n<=0) {
      System.out.println("Enter valid natural number");
    }

    //create arrays
    int[] even = new int[n/2+1];
    int[] odd = new int[n/2+1];

    //index variables
    int evenIndex = 0;
    int oddIndex = 0;

    //store odd and even numbers
    for (int i = 1; i <= n; i++) {
      if (i%2==0) {
        even[evenIndex++] = i;
        
      }

      else{
        odd[oddIndex++] = i;
      }

      
    }

    //print odd numbers
    for (int i = 0; i < oddIndex; i++) {
      System.out.println(odd[i]+" ");
    }

    //print even numbers
    for (int i = 0; i < evenIndex; i++) {
      
      System.out.println(even[i]+" ");
    }



    
    sc.close();
  }
}
