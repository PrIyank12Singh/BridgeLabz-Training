package review;
import java.util.*;

public class shifting_in_array {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];

    for(int i=0;i<n;i++){
      arr[i] = sc.nextInt();
    }

    int[] a = new int[n];

    int zero = 0;
    int ones = 0;
    int twos = 0;

    for (int i = 0; i < arr.length; i++) {
      if(arr[i]==0){
        zero++;
      }

      else if (arr[i]==1) {
        ones++;
      }

      else if(arr[i]==2){
        twos++;
      }


    }

    int idx = 0;

    for(int i=0;i<n;i++){
      if(arr[i]==0){
        a[idx++] = arr[i];
      }

      else if (arr[i]==1) {
        
        a[idx++] = arr[i];
      }

      else if (arr[i]==2) {
        a[idx++] = arr[i];
      }

    }



    

    
    for (int i=1;i<n ;i++ ){
        if (arr[i-1]>arr[i]){
            a[idx++] = arr[i]; 
        } 
        
        else if(arr[i]>arr[i-1]){
            a[idx++] = arr[i-1];
        }
        
        
        
        
    } 



    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]+" ");
    }
    



    sc.close();
  }
}
