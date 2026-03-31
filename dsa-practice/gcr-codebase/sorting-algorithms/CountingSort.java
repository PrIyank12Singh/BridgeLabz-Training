import java.util.*;
public class CountingSort {

  public static void countingSort(int[] ages){
    int minAge = 10;
    int maxAge = 18;
    int range = maxAge-minAge+1;

    //create count array
    int[] count = new int[range];

    //store frequency of each age
    for(int age:ages){
      count[age-minAge]++;
    }

    //computing cumulative  frequencies
    for (int i = 1; i < count.length; i++) {
      count[i] += count[i-1];
    }

    //build output array 
    int[] output = new int[ages.length];

    //traverse input from right to left for stability 
    for (int i = ages.length-1; i >=0; i--) {
      int age = ages[i];
      int position = count[age-minAge]-1;
      output[position] = age;
      count[age-minAge]--;
    }

    //copy sorted data back to original array 
    for (int i = 0; i < ages.length; i++) {
      ages[i] = output[i];
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of students: ");
    int n=  sc.nextInt();

    int[] ages = new int[n];

    System.out.println("Enter ages of students: ");
    for (int i = 0; i < ages.length; i++) {
      ages[i] = sc.nextInt();

    }

    countingSort(ages);

    System.out.println("Sorted Ages: ");
    for(int age:ages){
      System.out.print(age+" ");
    }

    sc.close();
  }
}
