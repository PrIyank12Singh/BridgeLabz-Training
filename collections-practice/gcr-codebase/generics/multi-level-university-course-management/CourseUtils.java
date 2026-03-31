import java.util.List;

public class CourseUtils {

    public static void displayCourses(List<? extends CourseType> courseTypes) {
        for (CourseType type : courseTypes) {
            System.out.println(
                type.getTypeName() + " | Evaluation: " + type.getEvaluationMethod()
            );
        }
    }
}
