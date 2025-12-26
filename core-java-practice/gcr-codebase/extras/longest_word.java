import java.util.*;

public class longest_word {

  public static String LongestWord(String str){

    //method for finding Longest Word in a String
    String st[] = str.split(" ");
    String longestWord = "";

    for (int i = 0; i < st.length; i++) {

      if(st[i].length()>longestWord.length()){
        longestWord = st[i];
      }
      

      
    }

    return longestWord;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    //taking string as input
    String str = sc.nextLine();

    //method calling
    String LongestWord = LongestWord(str);

    System.out.println("Longest Word in a String: "+LongestWord);
    
    sc.close();
  }  
}
