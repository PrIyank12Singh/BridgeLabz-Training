import java.util.*;

public class FestivalLuckyDraw {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    //taking visitors as input
    int visitors = sc.nextInt();

    for (int i = 1; i <= visitors; i++) {
      System.out.print("Visitor "+ i + ", draw a number: ");
      int num = sc.nextInt();

      //Invalid input check
      if (num<=0) {
        System.out.println("Invalid number");
        continue;
      }


      //check divisibility by 3 and 5
      if (num%3==0 && num%5==0) {
        System.out.println("Visitor "+i+" wins a gift.");

      }

      else{
        System.out.println("Visitor "+i+" does not wins a gift.");
      }
    }

    sc.close();
  }
}
