import java.util.*;

public class ToggleCase {
  public static String toggleCase(String str){
    
    String result = "";

    for (int i = 0; i < str.length(); i++) {

      char ch = str.charAt(i);
      
      //If lowercase, then convert it to uppercase
      if(ch>='a' && ch<='z'){
        result += (char)(ch-32);
      }

      //If uppercase, then convert it to lowercase
      else if(ch>='A' && ch<='Z'){
        result += (char)(ch+32);
      }

      //Other characters remains same
      else{
        result+=ch;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    //taking input String 
    String str = sc.nextLine();

    //method call
    String toggled = toggleCase(str);

    System.out.println("Toggled String: "+toggled);
    sc.close();
  }
}
