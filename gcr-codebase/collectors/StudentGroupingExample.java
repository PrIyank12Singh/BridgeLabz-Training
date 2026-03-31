import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    String grade;

    Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() { return name; }
    public String getGrade() { return grade; }
}

public class StudentGroupingExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", "A"),
            new Student("Bob", "B"),
            new Student("Charlie", "A"),
            new Student("David", "C"),
            new Student("Eve", "B")
        );

        Map<String, List<String>> groupedByGrade = students.stream()
            .collect(Collectors.groupingBy(
                Student::getGrade,
                Collectors.mapping(Student::getName, Collectors.toList())
            ));

        System.out.println(groupedByGrade);
    }
}
