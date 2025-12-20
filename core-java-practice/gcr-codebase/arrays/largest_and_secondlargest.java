import java.util.*;

public class largest_and_secondlargest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    int maxDigit = 10;
    int[] digits = new int[maxDigit];
    int index = 0;

    //seperating digits of number and storing it in array
    while (num!=0 && index<maxDigit) {
      digits[index++] = num%10;
      num/=10;

    }

    int largest = 0, secondLargest = 0;

    //finding the largest and second largest digit from array
    for (int i = 0; i < index; i++) {
      if (digits[i]>largest) {
        secondLargest = largest;
        largest= digits[i];
      }

      else if (digits[i]>secondLargest && digits[i]!=largest) {
        secondLargest = digits[i];

      }
    }

    System.out.println("Largest = "+largest);
    System.out.println("Second Largest = "+secondLargest);
    sc.close();
  }
}
