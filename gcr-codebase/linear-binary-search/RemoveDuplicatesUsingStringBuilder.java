import java.util.*;
public class RemoveDuplicatesUsingStringBuilder {

  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter a String: ");
    String input = sc.nextLine();

    String result = removeDuplicates(input);

    System.out.println("String without duplicates: "+result);
    sc.close();
  }

  public static String removeDuplicates(String str){
    StringBuilder sb = new StringBuilder();
    HashSet<Character> seen = new HashSet<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (!seen.contains(ch)) {
        sb.append(ch);
        seen.add(ch);
      }
    }

    return sb.toString();
    
  }
}
