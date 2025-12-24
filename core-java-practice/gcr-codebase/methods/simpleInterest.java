import java.util.*;

public class simpleInterest {
  
  //formula for calculating Simple Interest
  public static double sI(double principal, double rate, double time){
    return (principal*rate*time)/100;
  }

  //taking principal, rate, time as input
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double principal = sc.nextInt();
    double rate = sc.nextInt();
    double time = sc.nextInt();

    double calculation = sI(principal,rate,time);

    System.out.println("The Simple Interest is "+calculation+"for Principal "+principal+",Rate of Interest "+rate+" and Time "+time);
    sc.close();
  }
}
