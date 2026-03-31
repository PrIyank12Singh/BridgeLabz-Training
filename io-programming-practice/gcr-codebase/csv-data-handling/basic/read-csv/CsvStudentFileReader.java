import java.io.*;

public class CsvStudentFileReader {

    public static void main(String[] args) {

        String filePath = "students.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);

                CsvStudentRecord student =
                        new CsvStudentRecord(id, name, age, marks);

                student.printRecord();
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file");
        }
    }
}
