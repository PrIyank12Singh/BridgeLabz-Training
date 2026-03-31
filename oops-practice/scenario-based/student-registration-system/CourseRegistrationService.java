public class CourseRegistrationService implements RegistrationService {

    private static final int MAX_COURSES = 3;

    public void enroll(Student student, String course) throws CourseLimitExceededException {
        if (student.getCourseCount() >= MAX_COURSES) {
            throw new CourseLimitExceededException("Course limit exceeded");
        }

        student.addCourse(course);
        System.out.println("Enrolled in " + course);
    }

    public void drop(Student student, String course) {
        student.removeCourse(course);
        System.out.println("Dropped " + course);
    }
}
