import java.util.*;

public class palindromic_string {

  public static void checkingPalindromicString(String str){
    
    //method for checking palindromic string
    int n = str.length();
    
    

    int i=0;
    int t = n-1;

    boolean isPalindrome = true;
    while (i<=t) {
      if (str.charAt(i)==str.charAt(t)) {
        
        i++;
        t--;

        continue;
        
      }

      else{

        isPalindrome = false;
        break;

      } 


      

    }

    if(isPalindrome){
        System.out.println("Yes, the string is Palindrome");
    }

    else{
      System.out.println("No, the string is not Palindrome");
    }

  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //Taking input String 
    String str = sc.next();


    //method calling
    checkingPalindromicString(str);
    
    sc.close();
  }
}
