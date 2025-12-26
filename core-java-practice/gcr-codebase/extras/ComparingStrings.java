import java.util.*;

public class ComparingStrings {
  public static void comparingStrings(String string1, String string2){
    //Method to compare two Strings lexicographically
    int i = 0;

    //compare character by character

    while (i<string1.length() && i<string2.length()) {
      if (string1.charAt(i)< string2.charAt(i)) {
        System.out.println("\""+string1+"\" comes before\""+string2+"\" in lexicographical order");
        return;
      }

      else if(string2.charAt(i)<string1.charAt(i)){
        System.out.println("\""+string2 +"\" comes before\""+string1+"\" in lexicographical order");
        return;
      }

      i++;
    }

    //if all compared characters are equal 
    if (string1.length()<string2.length()) {
      System.out.println("\""+string1+"\" comes before \""+string2+"\" in lexicographical order");
    }

    else if (string1.length()>string2.length()) {
      System.out.println("\""+string2+"\" comes before \""+string1+"\" in lexicographical order");
    }

    else{
      System.out.println("Both strings are equal");
    }


  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //taking both strings as a input
    String string1 = sc.nextLine();
    String string2 = sc.nextLine();

    //Method call
    comparingStrings(string1, string2);

    
    sc.close();


  }
}
