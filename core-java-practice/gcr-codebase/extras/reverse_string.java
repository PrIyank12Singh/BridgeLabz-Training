import java.util.*;
public class reverse_string {
  
  public static void reversingAstring(String str){

    //method for reversing a String
    String st = "";

    for (int i = str.length()-1; i >=0; i--) {
      char ch = str.charAt(i);

      st = st+ch;
    }

    System.out.println("The reverse String of input: "+st);
  }
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    //Taking input
    String str = sc.next();

    //Calling Method
    reversingAstring(str);

    
    sc.close();
  }
}
