import java.util.*;

public class percentage_and_grade_1D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    double[] percentage = new double[n];
    String[] grade = new String[n];
    String[] remark = new String[n];

    for (int i = 0; i < n; i++) {
      double p = sc.nextDouble();
      double c = sc.nextDouble();
      double m = sc.nextDouble();

      percentage[i] = (p+c+m)/3;

      if(percentage[i]>=80){
      grade[i]= "A";
      remark[i] = "(Level 4, above agency-normalized standards)";
      }

      else if(percentage[i]>=70){
        grade[i]="B";
        remark[i] = "(Level 3, at agency-normalized standards)";
      }

      else if(percentage[i]>=60){
        grade[i]="C";
        remark[i] = "(Level 2, below,but approaching agency-normalized standards)";
      }

      else if(percentage[i]>=50){
        grade[i]="D";
        remark[i] = "(Level 1, well below agency-normalized standards)";
      }

      else if(percentage[i]>=40){
        grade[i]="E";
        remark[i] = "(Level 1-, too below agency-normalized standards)";
      }

      else if(percentage[i]<=39){
        grade[i]="R";
        remark[i] = "(Remedial Standards)";
      }
    }

    for (int i = 0; i < n; i++) {
      System.out.println(grade[i]+" "+remark[i]+" "+percentage[i]);
    }
    sc.close();
    
  }
}
