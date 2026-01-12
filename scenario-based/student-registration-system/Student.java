public class Student extends Person {

    private String[] courses;
    private String[] grades;
    private int courseCount;
    private int gradeCount;

    public Student(int id, String name) {
        super(id, name);
        courses = new String[5];
        grades = new String[5];
        courseCount = 0;
        gradeCount = 0;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public void addCourse(String course) {
        courses[courseCount++] = course;
    }

    public void removeCourse(String course) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].equals(course)) {
                for (int j = i; j < courseCount - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[courseCount - 1] = null;
                courseCount--;
                break;
            }
        }
    }

    public void addGrade(String grade) {
        grades[gradeCount++] = grade;
    }

    public void viewGrades() {
        for (int i = 0; i < gradeCount; i++) {
            System.out.println(grades[i]);
        }
    }
}
