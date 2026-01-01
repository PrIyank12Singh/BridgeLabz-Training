class Student {

    // static variables
    static String universityName = "Global University";
    static int totalStudents = 0;

    // instance variables
    String name;
    String grade;

    // final variable
    final int rollNumber;

    // constructor using this
    Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    // static method
    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // update grade using instanceof
    void updateGrade(Object obj, String newGrade) {
        if (obj instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated to: " + newGrade);
        }
    }

    // display details
    void displayDetails(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + student.rollNumber);
            System.out.println("Name: " + student.name);
            System.out.println("Grade: " + student.grade);
            System.out.println();
        }
    }
}

public class StudentApp {
    public static void main(String[] args) {

        Student student1 = new Student(101, "Hemashree", "A");
        Student student2 = new Student(102, "Sharmila", "B");

        Student.displayTotalStudents();

        student1.displayDetails(student1);
        student2.displayDetails(student2);

        student2.updateGrade(student2, "A");
        student2.displayDetails(student2);
    }
}
