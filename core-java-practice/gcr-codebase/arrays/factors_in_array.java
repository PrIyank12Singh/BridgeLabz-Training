import java.util.*;

public class factors_in_array {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    if(n<=0){
      System.out.println("Invalid Input");
    }

    //intialize array
    int maxFactor = 10;
    int[] factors = new int[maxFactor];
    int index = 0;

    //find factors
    for (int i = 1; i <= n; i++) {
      if (n%i==0) {
        
        //resize array if full
        if (index==maxFactor) {
          maxFactor *=2;

          int[] temp = new int[maxFactor];

          //copy old values
          for (int j = 0; j < factors.length; j++) {
            temp[j] = factors[j];
          }

          factors = temp;
        }

        //store factor 
        factors[index] = i;
        index++;
      }
    }

    //display factors
    for (int i = 0; i < index; i++) {
      
      System.out.println(factors[i]+" ");
    }

    sc.close();
  }
}
