import java.util.*;
public class Double_Operations {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //Taking input
    //Taking a,b and c as a input
    double a = sc.nextInt();
    double b = sc.nextInt();
    double c = sc.nextInt();

    double opt1 =  a + b *c;               //Operation 1

    double opt2 = a * b + c;                //Operation 2

    double opt3 =  c + a / b;               //Operation 3

    double opt4 = a % b + c;                //Operation 4

    System.out.println("The results of Int Operations are " +opt1+ " , "+opt2+" , "+opt3+" and "+opt4
    );

    sc.close();
  }
}

