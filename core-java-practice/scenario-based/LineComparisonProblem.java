import java.util.*;
public class LineComparisonProblem {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    LineComparisonPrint();

    System.out.println("Enter x co-ordinates: ");
    String p1= sc.nextLine();

    System.out.println("Enter y co-ordinates: ");
    String p2 = sc.nextLine();

    int x1= p1.charAt(0)-'0';
    int y1 = p2.charAt(0)-'0';
    int x2 = p1.charAt(p1.length()-1)-'0';
    int y2 = p2.charAt(p2.length()-1)-'0';

    double length1 = LengthOfLine_1(x1, y1, x2, y2);

    System.out.println("Length1 of a Line=  "+length1);


    System.out.println("Enter a co-ordinates: ");
    String p3= sc.nextLine();

    System.out.println("Enter b co-ordinates: ");
    String p4 = sc.nextLine();

    int a1= p3.charAt(0)-'0';
    int b1 = p4.charAt(0)-'0';
    int a2 = p3.charAt(p3.length()-1)-'0';
    int b2 = p4.charAt(p4.length()-1)-'0';

    double length2 = LengthOfLine_2(a1,b1,a2,b2);

    System.out.println("Length2 of a Line=  "+length2);

    boolean equality = LengthEquals(length1, length2);

    System.out.println("Are both Lengths equal = "+equality);

    LengthComparison(length1, length2);


    

    sc.close();
  }

  public static void LineComparisonPrint(){
    System.out.println("Welcome to Line Comparison Computation Program");
  }

  public static double LengthOfLine_1(int x1,int y1,int x2,int y2){
    double length = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1, 2));
    return length;
  }

  public static double LengthOfLine_2(int a1,int b1,int a2,int b2){
    double length = Math.sqrt(Math.pow(a2-a1,2)+Math.pow(b2-b1, 2));
    return length;
  }

  public static boolean LengthEquals(double length1,double length2){
    if (length1==length2) {
      return true;
    }

    else return false;
  }

  public static void LengthComparison(double length1,double length2){
    if (length1==length2) {
      System.out.println("Both lengths are equal");
    }

    else if(length1>length2){
      System.out.println("Length 1 is greater than Length 2");
    }

    else if(length1<length2){
      System.out.println("Length 2 is greater than Length 1");
    }


  }
  
  


}
