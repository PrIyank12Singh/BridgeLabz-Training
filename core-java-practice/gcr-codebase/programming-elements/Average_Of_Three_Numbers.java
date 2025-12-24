import java.util.*;

public class Average_Of_Three_Numbers {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    int avg = (a+b+c)/3;
    System.out.println(avg);
    sc.close();
  }
}
