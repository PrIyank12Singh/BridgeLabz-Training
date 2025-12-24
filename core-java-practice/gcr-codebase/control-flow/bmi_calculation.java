import java.util.*;
public class bmi_calculation {
  public static void main(String[] args) {
    //Taking n as a input
    Scanner sc = new Scanner(System.in);
    //input weight and height

    double weight = sc.nextDouble();

    double height_cm = sc.nextDouble();
    //converting height from  centimeters to meters
    double height_m = height_cm/100;

    //calculate bmi
    double bmi = weight/(height_m*height_m);

    String status="";

    if(bmi<=18.4){
      status = "Underweight";
    }

    else if(bmi<25){
      status = "Normal";
    }

    else if(bmi<40){
      status =  "Overweight";
    }

    else if(bmi>=40){
      status = "Obese";
    }

    System.out.println("BMI = "+bmi);
    System.out.println("Weight Status = "+status);

    sc.close();
  }
}
