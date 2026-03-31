import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvStudentObjectMapper {

    public static void main(String[] args) {

        String filePath = "student_object_list_input.csv";
        String line;
        boolean isHeader = true;

        List<CsvStudentObject> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ((line = br.readLine()) != null) {

                if (isHeader) {
                    isHeader = false; // skip header
                    continue;
                }

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);

                CsvStudentObject student = new CsvStudentObject(id, name, age, marks);
                students.add(student);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file");
            return;
        }

        // Print all students
        System.out.println("Student Records:");
        for (CsvStudentObject student : students) {
            student.printStudent();
        }
    }
}
