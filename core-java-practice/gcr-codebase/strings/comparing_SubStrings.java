import java.util.*;

public class comparing_SubStrings {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    //take input
    String text = sc.next();

    int start = sc.nextInt();

    int end = sc.nextInt();

    //create substring using charAt()
    String sub1 = "";
    for (int i = start; i < end; i++) {
      sub1+=text.charAt(i);
    }

    //create substring using built-in method
    String sub2 = text.substring(start,end);

    //compare both substring using charAt()
    boolean same = true;

    if(sub1.length()!=sub2.length()){
      same = false;
    }

    else{
      for (int i = 0; i < sub1.length(); i++) {
        if (sub1.charAt(i)!=sub2.charAt(i)) {
          same = false;
          break;
        }
      }
    }

    //output
    System.out.println("Substring using charAt(): "+sub1);
    System.out.println("Substring using substring(): "+sub2);
    System.out.println("Are  both substrings equal? "+same);
    sc.close();
  }
}
