import java.util.*;
public class bmi_1D_array {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //taking input
    int n = sc.nextInt();
    double[] weight = new double[n];
    double[] height = new double[n];
    double[] bmi = new double[n];
    String[] status = new String[n];

    //checking bmi
    for (int i = 0; i < n; i++) {
      weight[i]= sc.nextDouble();
      height[i] = sc.nextDouble();

      bmi[i] = weight[i]/(height[i]*height[i]);

      if (bmi[i]<18.5) {
        status[i]= "Underweight";
      }

      else if (bmi[i]<25) {
        status[i] = "Normal";
      }

      else if(bmi[i]<40){
        status[i] = "Overweight";
      }

      else{
        //
        status[i]="Obese";
      }
    }

    for (int i = 0; i < n; i++) {
      System.out.println(weight[i]+" "+height[i]+" "+bmi[i]+" "+status[i]);
    }
    sc.close();
  }
}
