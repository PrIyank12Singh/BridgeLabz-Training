import java.util.*;

public class MostFrequentCharacter {
  
  public static char findMostFrequentChar(String str){
    int[] freq = new int[256]; //ASCII frequency array

    //count frequency of each character 
    for (int i = 0; i < str.length(); i++) {
      freq[str.charAt(i)]++;
    }

    int maxCount = 0;
    char mostFrequent = str.charAt(0);

    //find character with maximum frequency 
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (freq[ch]>maxCount) {
        maxCount = freq[ch];
        mostFrequent = ch;
      }
    }

    return mostFrequent;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //taking string as a input
    String str = sc.nextLine();

    char result = findMostFrequentChar(str);

    System.out.println("Most frequent Character in a String: "+result);
    sc.close();
  }
}
