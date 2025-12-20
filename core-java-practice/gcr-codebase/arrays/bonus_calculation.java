import java.util.*;

public class bonus_calculation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    double[] salary = new double[10];
    double[] service = new double[10];
    double[] bonus = new double[10];
    double[] newSalary = new double[10];

    double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

    for (int i = 0; i < 10; i++) {
      System.out.println("Employee "+(i+1));

      salary[i] = sc.nextDouble();

      service[i] = sc.nextDouble();

      if (salary[i]<=0 || service[i]<0) {
        System.out.println("Invalid input");
        i--;
        continue;
      }
    }

    for (int i = 0; i < 10; i++) {
      if (service[i]>5) 
        bonus[i] = salary[i] * 0.5;

      else
        bonus[i] = salary[i] * 0.2;
      
      newSalary[i] = salary[i]+bonus[i];

      totalBonus+=bonus[i];
      totalOldSalary +=salary[i];
      totalNewSalary+=newSalary[i];
    }

    System.out.println("Total Bonus = "+totalBonus);
    System.out.println("Total Old Salary = "+totalOldSalary);
    System.out.println("Total new Salary = "+totalNewSalary);
    sc.close();
  }
}
