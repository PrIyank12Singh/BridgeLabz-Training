import java.util.*;

public class bmi_2D_array {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    double[][] person_data = new double[n][3];
    String[] status = new String[n];

    //checking bmi
    for (int i = 0; i < n; i++) {
      person_data[i][0] = sc.nextDouble(); //weight
      person_data[i][1] = sc.nextDouble(); //height

      person_data[i][2] = person_data[i][0] / (person_data[i][1]*person_data[i][1]);

      if(person_data[i][2]<18.5){
        status[i]= "Underweight";
      }

      else if(person_data[i][2]<25){
        status[i]= "Normal";
      }

      else if(person_data[i][2]<40){
        status[i]="Overweight";
      }

      else{
        status[i]="Obese";
      }
    }

    for (int i = 0; i < n; i++) {
      System.out.println(person_data[i][0]+" "+person_data[i][1]+" "+person_data[i][2]+" "+status[i]);
    }
    sc.close();
  }
}
