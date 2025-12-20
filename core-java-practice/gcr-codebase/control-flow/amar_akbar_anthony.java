import java.util.*;

public class amar_akbar_anthony {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //ages
    int amar_age = sc.nextInt();
    int akbar_age = sc.nextInt();
    int anthony_age = sc.nextInt();

    
    
    //heights
    int amar_height = sc.nextInt();
    int akbar_height = sc.nextInt();
    int anthony_height = sc.nextInt();


    //youngest 
    if(amar_age<=akbar_age && amar_age<=anthony_age){
      System.out.println("Youngest is Amar");
    }

    else if(akbar_age<=amar_age && akbar_age<=anthony_age){
      System.out.println("Youngest is Akbar");
    }

    else if(anthony_age<=amar_age && anthony_age<=akbar_age){
      System.out.println("Youngest is Anthony");
    }

    //tallest
    if(amar_height>=akbar_height && amar_height>=anthony_height){
      System.out.println("Tallest is Amar");
    }

    else if(akbar_height>=amar_height && akbar_height>=anthony_height){
      System.out.println("Tallest is Akbar");
    }

    else if(anthony_height>=amar_height && anthony_height>=akbar_height){
      System.out.println("Tallest is Anthony");
    }

    sc.close();
  } 
}
