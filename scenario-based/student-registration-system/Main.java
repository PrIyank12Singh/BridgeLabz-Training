public class Main {
    public static void main(String[] args) {

        Student student = new Student(1, "Priyank");

        RegistrationService service = new CourseRegistrationService();

        try {
            service.enroll(student, "Math");
            service.enroll(student, "Physics");
            service.enroll(student, "Computer Science");
            service.enroll(student, "Chemistry");
        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }

        service.drop(student, "Physics");

        student.addGrade("Math: A");
        student.addGrade("Computer Science: A+");

        System.out.println("Grades:");
        student.viewGrades();
    }
}
