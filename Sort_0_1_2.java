import java.util.*;
public class Sort_0_1_2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input
    int n = sc.nextInt();

    int[] arr = new int[n];
    //Taking array as input
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }
    for (int i = 0; i < arr.length; i++) {
      for (int j = 1; j < arr.length; j++) {
        if(arr[j-1]>arr[j]){
          int temp = arr[j-1];
          arr[j-1] = arr[j];
          arr[j] = temp;
        }
      }
    }

    for (int i:arr) {
      System.out.print(" "+i);
    }
    sc.close();
  }
}
