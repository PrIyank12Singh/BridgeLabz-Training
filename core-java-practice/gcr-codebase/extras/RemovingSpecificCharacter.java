import java.util.*;

public class RemovingSpecificCharacter {

  //method to remove specific character
  public static String removeCharacter(String str, char r){
    String result = "";

    for (int i = 0; i < str.length(); i++) {
      if(str.charAt(i)!=r){
        result+= str.charAt(i);
      }
    }

    return result;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //taking input of a String and character to remove
    String str = sc.nextLine();
    char r = sc.next().charAt(0);

    //method call 
    String modifiedString = removeCharacter(str, r);
    System.out.println("Modified String: \""+modifiedString+"\"");

    sc.close();
  }
}
