import java.util.ArrayList;
import java.util.Scanner;

// Custom Exception
class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

// Student class
class Student {
    private String name;
    private String[] subjects;
    private int[] marks;

    // Constructor with validation
    public Student(String name, String[] subjects, int[] marks) throws InvalidMarkException {
        if (subjects.length != marks.length) {
            throw new InvalidMarkException("Subjects and marks count mismatch.");
        }

        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException("Invalid mark found: " + mark);
            }
        }

        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public int[] getMarks() {
        return marks;
    }
}

// Report Generator
class ReportGenerator {
    private ArrayList<Student> students;

    // Constructor
    public ReportGenerator() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    // Calculate average
    public double calculateAverage(int[] marks) {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.length;
    }

    // Assign grade
    public String assignGrade(double average) {
        if (average >= 90) return "A+";
        if (average >= 75) return "A";
        if (average >= 60) return "B";
        if (average >= 45) return "C";
        return "F";
    }

    // Display report card
    public void displayReports() {
        System.out.println("\n   STUDENT REPORT CARDS   ");

        for (Student s : students) {
            System.out.println("\nStudent Name: " + s.getName());
            System.out.println( );

            String[] subjects = s.getSubjects();
            int[] marks = s.getMarks();

            for (int i = 0; i < subjects.length; i++) {
                System.out.printf("%-15s : %3d%n", subjects[i], marks[i]);
            }

            double avg = calculateAverage(marks);
            String grade = assignGrade(avg);

            System.out.println( );
            System.out.printf("Average Marks : %.2f%n", avg);
            System.out.println("Grade         : " + grade);
        }
    }
}

// Main Application 
public class StudentReportApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReportGenerator generator = new ReportGenerator();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            try {
                System.out.print("\nEnter student name: ");
                String name = sc.nextLine();

                System.out.print("Enter number of subjects: ");
                int count = sc.nextInt();
                sc.nextLine();

                String[] subjects = new String[count];
                int[] marks = new int[count];

                for (int j = 0; j < count; j++) {
                    System.out.print("Subject name: ");
                    subjects[j] = sc.nextLine();

                    System.out.print("Marks: ");
                    marks[j] = sc.nextInt();
                    sc.nextLine();
                }

                Student student = new Student(name, subjects, marks);
                generator.addStudent(student);

            } catch (InvalidMarkException e) {
                System.out.println("Error: " + e.getMessage());
                i--; // retry this student
            }
        }

        generator.displayReports();
        sc.close();
    }
}
