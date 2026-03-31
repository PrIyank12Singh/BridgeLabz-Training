import java.util.*;

public class multiply_from_6to9 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input
    int n = sc.nextInt();

    if(n<=0){
      System.out.println("Not a natural number");
    }

    else if(n>0){
      for(int i=6;i<=9;i++){
        int value = n * i;
        System.out.println(n+ " * "+i+ " = " + value);
      }
    }
    sc.close();
  }
}
