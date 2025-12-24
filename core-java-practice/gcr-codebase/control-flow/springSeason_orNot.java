import java.util.*;

public class springSeason_orNot {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //Taking input
    int month = sc.nextInt();
    int day = sc.nextInt();

    
    //Checking whether a given date is spring or not

    if(month>=3 && month<=6 ){
      if((month==3 && day<20)||(month==6 && day>20)){
        System.out.println("It's not a Spring Season");
      }
      
    }

    else{
      System.out.println("It's a Spring Season");
    }
    sc.close();
  }
}
