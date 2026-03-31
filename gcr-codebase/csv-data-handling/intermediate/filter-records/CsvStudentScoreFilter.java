import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvStudentScoreFilter {

    public static void main(String[] args) {

        String filePath = "students.csv";
        String line;
        boolean isHeader = true;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ((line = br.readLine()) != null) {

                if (isHeader) {
                    isHeader = false;   // skip header
                    continue;
                }

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);

                CsvStudentScoreRecord student =
                        new CsvStudentScoreRecord(id, name, age, marks);

                if (student.getMarks() > 80) {
                    student.printRecord();
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file");
        }
    }
}
