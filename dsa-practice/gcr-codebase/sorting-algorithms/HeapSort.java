import java.util.*;
public class HeapSort {
  
  //function for heap sort
  public static void heapSort(int[] arr){
    int n = arr.length;

    //Building max heap
    for (int i = n/2-1; i >=0; i--) {
      heapify(arr,n,i);


    }

    //extracting elements one by one
    for (int i = n-1; i >0; i--) {
      //move current root to end
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      //heapify reduced heap
      heapify(arr,i,0);
    }
  }

  //heapify a subtree rooted at index i
  public static void heapify(int[] arr, int size, int i) {
    int largest = i;
    int left = 2*i+1;
    int right = 2*i+1;

    //if left child is larger
    if(left<size && arr[left]>arr[largest]){
      largest = left;

    }

    //if right child is larger
    if (right<size && arr[right]>arr[largest]) {
      largest = right;
    }

    //if largest is not root 
    if (largest!=i) {
      int swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      //Recursively heapify the affected subtree
      heapify(arr, size, largest);
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of applications: ");
    int n = sc.nextInt();

    int[] salaries = new int[n];
    for (int i = 0; i < salaries.length; i++) {
      salaries[i] = sc.nextInt();
    }

    heapSort(salaries);

    System.out.println("Sorted salary demands: ");
    for(int salary:salaries){
      System.out.print(salary+" ");
    }
    sc.close();
  }
}
