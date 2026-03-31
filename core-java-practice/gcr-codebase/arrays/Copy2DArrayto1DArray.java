import java.util.*;

public class Copy2DArrayto1DArray {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    //taking rows and columns as input
    int rows = sc.nextInt();
    int columns = sc.nextInt();

    int[][] matrix = new int[rows][columns] ;

    //taking input for 2D array
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }

    //create 1D array
    int[] arr = new int[rows*columns];
    int index = 0;

    for (int i = 0; i <rows; i++) {
      
      for (int j = 0; j < columns; j++) {
        arr[index++] = matrix[i][j] ;
      }
    }

    //display 1D array

    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]+" ");
    }
    sc.close();
  }
}
