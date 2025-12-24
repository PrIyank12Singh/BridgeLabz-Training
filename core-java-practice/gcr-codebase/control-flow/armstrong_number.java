import java.util.*;

public class armstrong_number {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking n as a input
    int n = sc.nextInt();
    int original = n;

    int count =0;

    int temp = n;

    //to count digits
    if(n==0){
      count=1;
    }

    else{
      while(n>0){
        count++;
        temp=n/10;
      }
    }
    //armstrong logic
    int sum = 0;
    temp = n;
    while (count>0) {
      int num = temp%10;
      int power = 1;

      for (int i = 1; i <=count; i++) {
        power = power * num;
      }

      sum= sum+power;
      temp = temp/10;
    }

    //printing whether the number is armstrong or not
    if(sum==original){
      System.out.println(n+" is an Armstrong Number");
    }

    else{
      System.out.println(n+" is not an Armstrong Number");
    }
    
    sc.close();
  }
}
