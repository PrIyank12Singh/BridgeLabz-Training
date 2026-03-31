import java.util.*;
public class ReverseStringUsingStringBuilder {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter a string: ");
    String input = sc.nextLine();

    StringBuilder sb = new StringBuilder();
    sb.append(input);

    sb.reverse();

    //Convert back to String
    String reversed = sb.toString();

    System.out.println("Reversed String: "+reversed);
    sc.close();
  }  
}
