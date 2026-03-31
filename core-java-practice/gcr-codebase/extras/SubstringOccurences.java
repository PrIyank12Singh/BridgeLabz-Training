import java.util.*;

public class SubstringOccurences {
  
  public static int countOccurences(String str, String sub){
    int count = 0;

    for (int i = 0; i < str.length()-1; i++) {
      
      //checking substring match
      if (str.substring(i,i+sub.length()).equals(sub)) {
        count++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    //taking input
    String str = sc.nextLine();
    String sub = sc.nextLine();

    //method call
    int result = countOccurences(str, sub);
    System.out.println("Substring occurs "+result+" times");
    sc.close();
  }
}
