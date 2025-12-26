import java.util.*;

public class AnagramStrings {

  public static boolean areAnagram(String s1, String s2){

    //Remove spaces and convert to lowercase
    s1 = s1.replace(" "," ").toLowerCase();
    s2 = s2.replace(" "," ").toLowerCase();

    //If lengths are different, not anagrams
    if (s1.length()!= s2.length()) {
      return false;
    }

    int[] freq = new int[256];  //ASCII frequency array

    //Increase frequency for first String 
    for (int i = 0; i < s1.length(); i++) {
      freq[s1.charAt(i)]++;
    }

    //Decrease frequency for second string 
    for (int i = 0; i < s2.length(); i++) {
      freq[s2.charAt(i)]--;
    }

    //check if all frequencies are zero
    for (int i = 0; i < 256; i++) {
      if (freq[i]!=0) {
        return false;
      }
    }

    return true;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    //Taking input both strings
    String s1 = sc.nextLine();
    String s2 = sc.nextLine();

    //Method call
    if(areAnagram(s1, s2)){
      System.out.println("The strings are anagrams.");
    }

    else{
      System.out.println("The strings are not anagrams.");
    }

    sc.close();
  }
}
