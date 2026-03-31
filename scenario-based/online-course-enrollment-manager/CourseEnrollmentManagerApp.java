import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CourseEnrollmentManagerApp {

    public static void main(String[] args) {

        List<CourseEnrollmentRecord> enrollmentList = new ArrayList<>();

        enrollmentList.add(new CourseEnrollmentRecord(
                "Priyank", "Java Fundamentals", "Programming",
                LocalDate.of(2026, 1, 10)));

        enrollmentList.add(new CourseEnrollmentRecord(
                "Anita", "Spring Boot", "Programming",
                LocalDate.of(2026, 1, 15)));

        enrollmentList.add(new CourseEnrollmentRecord(
                "Rahul", "Digital Marketing", "Marketing",
                LocalDate.of(2026, 1, 12)));

        enrollmentList.add(new CourseEnrollmentRecord(
                "Vikram", "Data Analytics", "Data Science",
                LocalDate.of(2026, 1, 18)));

        enrollmentList.add(new CourseEnrollmentRecord(
                "Simran", "Java Fundamentals", "Programming",
                LocalDate.of(2026, 1, 20)));

        //Filter by Course Name
        System.out.println("Filter by Course: Java Fundamentals");
        enrollmentList.stream()
                .filter(record -> record.getCourseName().equalsIgnoreCase("Java Fundamentals"))
                .forEach(System.out::println);

        //Filter by Course Category
        System.out.println("\nFilter by Category: Programming");
        enrollmentList.stream()
                .filter(record -> record.getCourseCategory().equalsIgnoreCase("Programming"))
                .forEach(System.out::println);

        //Group by Course Name
        System.out.println("\nGrouped by Course Name:");
        Map<String, List<CourseEnrollmentRecord>> groupedByCourse =
                enrollmentList.stream()
                        .collect(Collectors.groupingBy(CourseEnrollmentRecord::getCourseName));

        groupedByCourse.forEach((course, records) -> {
            System.out.println(course + ":");
            records.forEach(System.out::println);
        });

        //Count Enrollments per Category
        System.out.println("\nEnrollment Count per Category:");
        Map<String, Long> categoryCount =
                enrollmentList.stream()
                        .collect(Collectors.groupingBy(
                                CourseEnrollmentRecord::getCourseCategory,
                                Collectors.counting()));

        categoryCount.forEach((category, count) ->
                System.out.println(category + " -> " + count));

        //Sort by Enrollment Date
        System.out.println("\nSorted by Enrollment Date:");
        enrollmentList.stream()
                .sorted(Comparator.comparing(CourseEnrollmentRecord::getEnrollmentDate))
                .forEach(System.out::println);
    }
}
