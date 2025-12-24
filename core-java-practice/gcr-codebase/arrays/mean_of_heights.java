import java.util.*;

public class mean_of_heights {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
  
    double[] team_heights = new double[11];
    double sum = 0.0;

    //take input for heights
    for (int i = 0; i < team_heights.length; i++) {
      team_heights[i] = sc.nextDouble();
    }

    //find sum of all heights
    for (int i = 0; i < team_heights.length; i++) {
      
      sum = sum+team_heights[i];
    }

    //calculate mean 
    double mean = sum/11;

    System.out.println("Mean height of the football team = "+mean);
    sc.close();
    
  }
}