import java.util.*;

public class reverse_number_by_array {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int temp = n, count = 0;

    while (temp!=0) {
      count++;
      temp/=10;
    }

    int[] digits = new int[count];
    for (int i = 0; i < count; i++) {
      digits[i]= n%10;
      n/=10;
    }

    System.out.println("Reversed Number: ");
    for (int i = 0; i < count; i++) {
      System.out.println(digits[i]);
    }
    sc.close();
  }
}
