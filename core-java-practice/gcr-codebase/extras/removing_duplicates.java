import java.util.*;

public class removing_duplicates {
  
  public static void removingDuplicates(String str){
    //method to check duplicates in a string and removing them
    String st = "";
    

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      //check if character is already present 
      if(st.indexOf(ch)==-1){
        st+=ch;
      }
    }

    System.out.println("After removing duplicates from a String: "+st);
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //taking input
    String str = sc.next();

    //Method Calling
    removingDuplicates(str);

    sc.close();


  }
}
