import java.util.*;

public class char_Compare {

  static char[] getChars(String s){
    char[] a = new char[s.length()];
    for (int i = 0; i < s.length(); i++) {
      a[i] = s.charAt(i);

    }
    return a;
  }

  static boolean compare(char[] a,char[] b){
    if(a.length != b.length) return false;
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) {
        return false;
      }

    }

    return true;
  }
  public static void main(String[] args) {
    //Taking input
    Scanner sc = new Scanner(System.in);
    String s = sc.next();

    char[] a1 = getChars(s);
    char[] a2 = s.toCharArray();

    System.out.println(compare(a1, a2));

    sc.close();
  }

  
}
