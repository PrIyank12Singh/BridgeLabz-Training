import java.util.*;

public class comparing_Stings {
  public static void main(String[] args) {
    //Taking input
    Scanner sc = new Scanner(System.in);
    
    //taking s1 and s2 as input
    String s1 = sc.next();
    String s2 = sc.next();

    int n = s1.length();
    
    boolean is_equal = true;

    //checking both strings by charAt method

    for(int i=0;i<n;i++){
      char ch = s1.charAt(i);
      char sh = s2.charAt(i);

      if(ch != sh){
        is_equal = false;
        break;
      }

      
    }

    //checking by equals method
    boolean b = s1.equals(s2);

    //comparing the result and printing boolean value according to it
    if(is_equal == b){
      System.out.println(b);
    }

    else{
      System.out.println("false");
    }
    sc.close();
  }
}
