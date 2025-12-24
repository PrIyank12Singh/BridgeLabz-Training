import java.util.*;

public class multiplication_of_number {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int num = n;

    int[] a = new int[11];

    //printing the table of input number 

    for (int i = 1; i < a.length; i++) {
      
      a[i] = num*i;
      System.out.println(num+" * "+i+ " = "+ a[i]);
    }
    sc.close();
  }
}
