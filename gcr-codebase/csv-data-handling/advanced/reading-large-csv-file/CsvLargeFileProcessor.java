import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvLargeFileProcessor {

    public static void main(String[] args) {

        String filePath = "large_student_records_input.csv";
        int batchSize = 100; // process 100 lines at a time
        int totalProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean isHeader = true;
            List<CsvLargeStudentRecord> batch = new ArrayList<>();

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

                batch.add(new CsvLargeStudentRecord(id, name, age, marks));

                // Process batch when full
                if (batch.size() == batchSize) {
                    totalProcessed += batch.size();
                    System.out.println("Processed records: " + totalProcessed);
                    batch.clear(); // free memory
                }
            }

            // Process remaining records
            if (!batch.isEmpty()) {
                totalProcessed += batch.size();
                System.out.println("Processed records: " + totalProcessed);
                batch.clear();
            }

            System.out.println("Total records processed: " + totalProcessed);

        } catch (IOException e) {
            System.out.println("Error reading CSV file");
        }
    }
}
