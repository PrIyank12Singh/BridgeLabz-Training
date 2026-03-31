import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvEmployeeContactValidator {

    public static void main(String[] args) {

        String filePath = "employee_contact_validation_input.csv";
        String line;
        boolean isHeader = true;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ((line = br.readLine()) != null) {

                if (isHeader) {
                    isHeader = false; // skip header
                    continue;
                }

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                String phone = data[3];

                CsvEmployeeContactRecord employee =
                        new CsvEmployeeContactRecord(id, name, email, phone);

                if (!employee.isEmailValid() || !employee.isPhoneValid()) {
                    employee.printInvalidRecord();
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file");
        }
    }
}
