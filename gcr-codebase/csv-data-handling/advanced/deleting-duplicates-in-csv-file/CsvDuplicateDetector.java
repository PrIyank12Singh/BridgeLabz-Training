import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvDuplicateDetector {

    public static void main(String[] args) {

        String filePath = "student_duplicates_input.csv";
        Map<Integer, Integer> idCountMap = new HashMap<>();
        Map<Integer, CsvStudentDuplicateRecord> recordMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

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
                int marks = Integer.parseInt(data[3]);

                CsvStudentDuplicateRecord record = new CsvStudentDuplicateRecord(id, name, age, marks);

                // Track count of each ID
                idCountMap.put(id, idCountMap.getOrDefault(id, 0) + 1);
                // Keep the record (first occurrence)
                recordMap.putIfAbsent(id, record);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file");
            return;
        }

        // Print duplicates
        System.out.println("Duplicate Records:");
        boolean hasDuplicates = false;
        for (Map.Entry<Integer, Integer> entry : idCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                hasDuplicates = true;
                CsvStudentDuplicateRecord duplicateRecord = recordMap.get(entry.getKey());
                duplicateRecord.printRecord();
            }
        }

        if (!hasDuplicates) {
            System.out.println("No duplicates found.");
        }
    }
}
