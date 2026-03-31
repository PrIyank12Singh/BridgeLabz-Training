import java.util.*;

public class right_to_vote {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input
    //taking age as  input
    int a = sc.nextInt();

    if(a<18){
      System.out.println("The person's age is "+ a +" and cannot vote.");


    }

    else if(a>=18){
      System.out.println("The person's age is " +a+ " and can vote.");
    }
    sc.close();
  }
}
