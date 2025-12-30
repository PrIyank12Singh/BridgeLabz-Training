// student class to store student details
class Student {

    // attributes
    String name;
    String rollNumber;
    double mark1, mark2, mark3;

    // method to calculate grade based on average marks
    char calculateGrade() {
        double average = (mark1 + mark2 + mark3) / 3;

        if (average >= 75)
            return 'A';
        else if (average >= 60)
            return 'B';
        else
            return 'C';
    }

    // method to display student details and grade
    void displayReport() {
        System.out.println("Student Name: " + name);
        System.out.println("Student RollNumber: " + rollNumber);
        System.out.println("Student Marks:");
        System.out.println("Mark1: " + mark1);
        System.out.println("Mark2: " + mark2);
        System.out.println("Mark3: " + mark3);
        System.out.println("Grade " + calculateGrade());
        System.out.println();
    }

    // main method
    public static void main(String[] args) {

        // First student object
        Student student1 = new Student();
        student1.name = "Thamarai";
        student1.rollNumber = "ECE001";
        student1.mark1 = 80;
        student1.mark2 = 70;
        student1.mark3 = 75;

        // Second student object
        Student student2 = new Student();
        student2.name = "Kannan";
        student2.rollNumber = "CSC002";
        student2.mark1 = 60;
        student2.mark2 = 65;
        student2.mark3 = 50;

        // Display reports
        student1.displayReport();
        student2.displayReport();
    }
}
