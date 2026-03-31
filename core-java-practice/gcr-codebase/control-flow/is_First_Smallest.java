import java.util.*;

public class is_First_Smallest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input

    //Taking a,b,c as input
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    //checking whether a is smaller than b and c
    if(a<b && a<c){
      System.out.println("Is the first number the smallest? Yes");
    }

    else if(a>b || a>c){
      System.out.println("Is the first number the smallest? No");
    }
    sc.close();
  }
}
