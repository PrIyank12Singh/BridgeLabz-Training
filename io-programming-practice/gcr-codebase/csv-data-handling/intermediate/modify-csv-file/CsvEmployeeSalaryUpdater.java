import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvEmployeeSalaryUpdater {

    public static void main(String[] args) {

        String inputFile = "employee_salary_update_input.csv";
        String outputFile = "employee_salary_update_output.csv";
        List<CsvEmployeeSalaryRecord> employees = new ArrayList<>();
        String line;
        boolean isHeader = true;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

            // Read input CSV
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // skip header
                    continue;
                }

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String department = data[2];
                double salary = Double.parseDouble(data[3]);

                CsvEmployeeSalaryRecord employee =
                        new CsvEmployeeSalaryRecord(id, name, department, salary);

                // Increase salary if department is IT
                if (employee.getDepartment().equalsIgnoreCase("IT")) {
                    employee.increaseSalaryByPercent(10);
                }

                employees.add(employee);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file");
            return;
        }

        // Write updated CSV
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            // Write header
            bw.write("ID,Name,Department,Salary");
            bw.newLine();

            // Write records
            for (CsvEmployeeSalaryRecord emp : employees) {
                bw.write(emp.toCsvRow());
                bw.newLine();
            }

            System.out.println("Updated CSV written to " + outputFile);

        } catch (IOException e) {
            System.out.println("Error writing CSV file");
        }
    }
}
