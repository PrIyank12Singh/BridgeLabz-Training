import java.util.*;

public class youngest_and_tallest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    String[] names = {"Amar", "Akbar", "Anthony"};
    int[] age = new int[3];
    double[] height = new double[3];

    //taking input of 3's height and age
    for (int i = 0; i < 3; i++) {
      System.out.println("Enter age of "+names[i]+": ");
      age[i] = sc.nextInt();
      System.out.println("Enter height of "+names[i]+": ");
      height[i] = sc.nextDouble();
    }

    int youngestIndex = 0, tallestIndex = 0;
    
    //finding who is youngest and who is tallest
    for (int i = 1; i < 3; i++) {
      if (age[i]<age[youngestIndex]) {
        
        youngestIndex = i;
      }

      if(height[i]>height[tallestIndex])
        tallestIndex = i;
    } 

    System.out.println("Youngest: "+names[youngestIndex]);
    System.out.println("Tallest: "+names[tallestIndex]);
    sc.close();
  }
}
