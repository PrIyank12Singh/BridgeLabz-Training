import java.util.*;

public class MaximumHandshakes {
  public static int combination(int numberOfStudents){

    return (numberOfStudents*(numberOfStudents-1))/2;
  }

  //taking numberOfStudents as input
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numberOfStudents = sc.nextInt();

    int result = combination(numberOfStudents);

    System.out.println("The maximum number of possible handshakes: "+result);

    sc.close();
  }
}
