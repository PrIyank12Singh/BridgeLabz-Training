public class ExamCourse extends CourseType {

    public ExamCourse() {
        super("Written Exams");
    }

    @Override
    public String getTypeName() {
        return "Exam Based";
    }
}
