import java.util.*;

public class harshad_number {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int sum = 0;
    int temp = n;
    int original = n;

    //logic for harshad(niven number)

    while (temp>0) {
      int digit = temp%10;
      sum += digit;
      temp = temp/10;
    }

    if(original%sum==0){
      System.out.println(n+" is a Harshad Number");
    }

    else{
      System.out.println(n+" is not a Harshad Number");
    }

    sc.close();
  }
}
