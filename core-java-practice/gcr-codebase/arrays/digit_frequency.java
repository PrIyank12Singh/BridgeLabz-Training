import java.util.*;

public class digit_frequency {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    int[] freq = new int[10];

    while (num!=0) {
      freq[num%10]++;
      num/=10;
    }

    for (int i = 0; i < 10; i++) {
      System.out.println(i+" occurs "+freq[i]+" times");
    }

    sc.close();
  }
}
