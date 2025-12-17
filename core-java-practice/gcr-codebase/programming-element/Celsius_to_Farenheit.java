import java.util.*;

public class Celsius_to_Farenheit {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int celsius = sc.nextInt();
    int farenheit = ((9/5)*celsius)+32;

    System.out.println(farenheit);

    sc.close();
  }

}
