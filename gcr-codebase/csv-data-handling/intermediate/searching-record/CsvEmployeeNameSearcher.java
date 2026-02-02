import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CsvEmployeeNameSearcher {

    public static void main(String[] args) {

        String filePath = "employee_search_data.csv";
        String line;
        boolean isHeader = true;
        boolean found = false;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ((line = br.readLine()) != null) {

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String department = data[2];
                double salary = Double.parseDouble(data[3]);

                CsvEmployeeSearchRecord employee =
                        new CsvEmployeeSearchRecord(id, name, department, salary);

                if (employee.getName().equalsIgnoreCase(searchName)) {
                    employee.printDepartmentAndSalary();
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found");
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file");
        }
    }
}
