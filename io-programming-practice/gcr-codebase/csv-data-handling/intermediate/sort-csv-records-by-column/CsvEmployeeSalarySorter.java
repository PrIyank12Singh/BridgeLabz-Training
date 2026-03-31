import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CsvEmployeeSalarySorter {

    public static void main(String[] args) {

        String filePath = "employee_salary_sort_input.csv";
        String line;
        boolean isHeader = true;
        List<CsvEmployeeSortRecord> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

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

                CsvEmployeeSortRecord employee =
                        new CsvEmployeeSortRecord(id, name, department, salary);

                employees.add(employee);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file");
            return;
        }

        // Sort employees by salary descending
        employees.sort(Comparator.comparingDouble(CsvEmployeeSortRecord::getSalary).reversed());

        System.out.println("Top 5 highest-paid employees:");

        // Print top 5
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            employees.get(i).printRecord();
        }
    }
}
