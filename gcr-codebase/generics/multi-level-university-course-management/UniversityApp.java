import java.util.ArrayList;
import java.util.List;

public class UniversityApp {

    public static void main(String[] args) {

        Course<ExamCourse> csCourse =
                new Course<>("Data Structures", "Computer Science", new ExamCourse());

        Course<AssignmentCourse> itCourse =
                new Course<>("Web Development", "Information Technology", new AssignmentCourse());

        Course<ResearchCourse> phdCourse =
                new Course<>("AI Research", "Computer Science", new ResearchCourse());

        List<CourseType> allCourseTypes = new ArrayList<>();
        allCourseTypes.add(csCourse.getCourseType());
        allCourseTypes.add(itCourse.getCourseType());
        allCourseTypes.add(phdCourse.getCourseType());

        System.out.println("University Course Evaluation Types:");
        CourseUtils.displayCourses(allCourseTypes);
    }
}
