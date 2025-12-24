import java.util.*;

public class age_to_vote {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


    int[] a = new int[10];

    //Taking age input
    for(int i=0;i<a.length;i++){
      a[i] = sc.nextInt();
    }

    //checking who has the right to vote or not

    for (int i = 0;i < a.length;i++) {
      
      if(a[i]>=18){
        System.out.println("The student with the age "+a[i]+" has right to vote");
      }

      else if(a[i]<18){
        System.out.println("The student with the age "+a[i]+" cannot vote");
      }

      else if(a[i]<0){
        System.out.println("Invalid Age Input");
      }
    }

    sc.close();
  }
}
