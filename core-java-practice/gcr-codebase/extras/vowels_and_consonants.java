import java.util.*;
public class vowels_and_consonants {

  //method to check Vowels and Consonants count in a String
  public static void countVowelsandConsonants(String input){
    int vowels = 0;
    int consonants = 0;

    input = input.toLowerCase();

    for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' ||
                    ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

    System.out.println("The count of vowels in String: "+vowels);
    System.out.println("The count of consonants in String: "+consonants);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //taking string as input
    String input = sc.next();

    
    //method call
    countVowelsandConsonants(input);




    sc.close();
  }
  
}
