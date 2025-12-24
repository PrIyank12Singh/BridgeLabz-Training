import java.util.*;

public class checking_number {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];

    for (int i = 0; i < a.length; i++) {
      a[i] = sc.nextInt();
    }

    for (int i = 0; i < a.length; i++) {
      if(a[i]>0){
        if(a[i]%2==0){
          System.out.println("The number is even");
        }

        else{
          System.out.println("The number is odd");
        }
      }

      else if(a[i]<0){
        System.out.println("Negative");
      }

      else if(a[i]==0){
        System.out.println("Zero");
      }


    }

    if(a[0]>a[n-1]){
      
      System.out.println("The first element is greater");
    }

    if(a[0]<a[n-1]){
      System.out.println("The last element is greater");
    }
    if(a[0]==a[n-1]){
      System.out.println("Both elements are equal");
    }


    sc.close();
  }
}