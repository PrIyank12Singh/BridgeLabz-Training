import java.util.*;

public class grading_on_average_of3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Taking input
    //taking marks of 3 subjects as input
    int physics = sc.nextInt();
    int chemistry = sc.nextInt();
    int maths = sc.nextInt();


    //calculate average 
    double average = (physics+chemistry+maths)/3.0;

    String grade ="";
    String remark= "";
    if(average>=80){
      grade="A";
      remark = "(Level 4, above agency-normalized standards)";
    }

    else if(average>=70){
      grade="B";
      remark = "(Level 3, at agency-normalized standards)";
    }

    else if(average>=60){
      grade="C";
      remark = "(Level 2, below,but approaching agency-normalized standards)";
    }

    else if(average>=50){
      grade="D";
      remark = "(Level 1, well below agency-normalized standards)";
    }

    else if(average>=40){
      grade="E";
      remark = "(Level 1-, too below agency-normalized standards)";
    }

    else if(average<=39){
      grade="R";
      remark = "(Remedial Standards)";
    }

    System.out.println("Grade = "+ grade);
    System.out.println("Remarks= " + remark);
    System.out.println("Average Marks = "+average);
    
    

    sc.close();

  }
}
