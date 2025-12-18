import java.util.*;


public class Int_Operations {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //Taking a,b and c as a input
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    int opt1 =  a + b *c;

    int opt2 = a * b + c;

    int opt3 =  c + a / b;

    int opt4 = a % b + c;

    System.out.println("The results of Int Operations are " +opt1+ " ,"+opt2+" ,"+opt3+" and"+opt4
);



    sc.close();
  }  
}
