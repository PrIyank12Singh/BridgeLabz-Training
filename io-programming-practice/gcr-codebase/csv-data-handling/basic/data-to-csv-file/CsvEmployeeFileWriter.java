import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvEmployeeFileWriter {

    public static void main(String[] args) {

        String filePath = "employees.csv";

        List<CsvEmployeeRecord> employees = new ArrayList<>();

        employees.add(new CsvEmployeeRecord(101, "Rahul", "IT", 55000));
        employees.add(new CsvEmployeeRecord(102, "Priya", "HR", 48000));
        employees.add(new CsvEmployeeRecord(103, "Amit", "Finance", 62000));
        employees.add(new CsvEmployeeRecord(104, "Neha", "Marketing", 50000));
        employees.add(new CsvEmployeeRecord(105, "Arjun", "Operations", 53000));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            writer.write("ID,Name,Department,Salary");
            writer.newLine();

            for (CsvEmployeeRecord emp : employees) {
                writer.write(emp.toCsvRow());
                writer.newLine();
            }

            System.out.println("Employee data written to CSV successfully");

        } catch (IOException e) {
            System.out.println("Error writing CSV file");
        }
    }
}
