import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CsvStudentMerger {

    public static void main(String[] args) {

        String file1 = "student_merge_input1.csv";
        String file2 = "student_merge_input2.csv";
        String outputFile = "student_merge_output.csv";

        Map<Integer, CsvStudentMergedRecord> studentMap = new HashMap<>();

        // Read first file (ID, Name, Age)
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {

            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);

                // Store student with default marks and grade
                CsvStudentMergedRecord student = new CsvStudentMergedRecord(id, name, age, 0, "");
                studentMap.put(id, student);
            }

        } catch (IOException e) {
            System.out.println("Error reading first CSV file");
            return;
        }

        // Read second file (ID, Marks, Grade) and merge
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {

            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                int marks = Integer.parseInt(data[1]);
                String grade = data[2];

                // Update existing student object using setters
                if (studentMap.containsKey(id)) {
                    CsvStudentMergedRecord student = studentMap.get(id);
                    student.setMarks(marks);
                    student.setGrade(grade);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading second CSV file");
            return;
        }

        // Write merged output
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            for (CsvStudentMergedRecord student : studentMap.values()) {
                bw.write(student.toCsvRow());
                bw.newLine();
            }

            System.out.println("Merged CSV written to " + outputFile);

        } catch (IOException e) {
            System.out.println("Error writing merged CSV");
        }
    }
}
