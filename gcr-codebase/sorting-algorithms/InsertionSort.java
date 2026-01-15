import java.util.Scanner;

public class InsertionSort {

  public static void insertionSort(int[] ids){
    int n = ids.length;

    for (int i = 0; i < n; i++) {
      int key = ids[i];
      int j = i-1;

      //shifting elements
      while (j>=0 && ids[j]>key) {
        ids[j+1] = ids[j];
        j--;
      }

      //Place key at correct position
      ids[j+1] = key;
    }
  }

  //Print array
  public static void printArray(int[] arr){
    for(int val:arr){
      System.out.print(val+" ");
    }

    System.out.println();
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter number of employees: ");
    int n = sc.nextInt();

    int[] empIds = new int[n];

    System.out.println("Enter employee IDs");
    for (int i = 0; i < empIds.length; i++) {
      empIds[i] = sc.nextInt();
    }

    System.out.println("Before Sorting: ");
    printArray(empIds);

    insertionSort(empIds);

    System.out.println("After sort: ");
    printArray(empIds);
    sc.close();

  }  
}
