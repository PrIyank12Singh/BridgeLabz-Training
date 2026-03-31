import java.util.*;

public class count_digits {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //Taking input
    int n = sc.nextInt();

    int count = 0;

    if(n==0){
      count=1;
    }

    //logic to count digits
    
    else{
      while (n>0) {
        count++;
        n=n/10;
      }
    }

    System.out.println("The count of "+n+" is "+count);
    sc.close();
  }
}
