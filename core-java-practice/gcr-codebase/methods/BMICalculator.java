import java.util.Scanner;

public class BMICalculator {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
          //converting height in centimeters to meters  
          double heightInMeters = data[i][1] / 100;
            data[i][2] = data[i][0] / (heightInMeters * heightInMeters);
        }
    }

    public static String getStatus(double bmi) {

      //determining bmi according to the data
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //taking data as input
        double[][] data = new double[10][3];

        for (int i = 0; i < 10; i++) {
            data[i][0] = scan.nextDouble(); // weight
            data[i][1] = scan.nextDouble(); // height
        }

        calculateBMI(data);

        for (int i = 0; i < 10; i++) {
            System.out.println(data[i][2] + " " + getStatus(data[i][2]));
        }

        scan.close();
    }
}
