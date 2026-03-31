import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvEmployeeRowCounter {

    public static void main(String[] args) {

        String filePath = "employees.csv";
        String line;
        int recordCount = 0;
        boolean isHeader = true;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ((line = br.readLine()) != null) {

                if (isHeader) {
                    isHeader = false;   // skip header
                    continue;
                }

                if (!line.trim().isEmpty()) {
                    recordCount++;
                }
            }

            System.out.println("Total employee records: " + recordCount);

        } catch (IOException e) {
            System.out.println("Error reading CSV file");
        }
    }
}
