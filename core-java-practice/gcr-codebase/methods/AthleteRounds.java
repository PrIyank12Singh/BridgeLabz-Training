import java.util.*;

public class AthleteRounds {
  
  //Method to calculate number of rounds
  public static double calculateRounds(double side1, double side2, double side3){
    double perimeter = side1+side2+side3;
    double totalDistance = 5000; //5 km in meters
    return totalDistance/ perimeter;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //taking input
    double side1 = sc.nextDouble();
    double side2 = sc.nextDouble();
    double side3 = sc.nextDouble();

    //method call 
    double rounds = calculateRounds(side1, side2, side3);

    //output
    System.out.println("Number of rounds required to complete 5 km: "+ rounds);

    sc.close();
  }
}
