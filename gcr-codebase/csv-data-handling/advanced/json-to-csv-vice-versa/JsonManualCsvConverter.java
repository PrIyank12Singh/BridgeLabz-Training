import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonManualCsvConverter {

    // JSON -> CSV
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line.trim());
            }

            String json = sb.toString();
            // Remove [ ] and split objects
            json = json.substring(1, json.length() - 1); // remove [ and ]
            String[] objects = json.split("\\},\\{");

            // Fix first and last objects after split
            for (int i = 0; i < objects.length; i++) {
                String obj = objects[i];
                if (!obj.startsWith("{")) obj = "{" + obj;
                if (!obj.endsWith("}")) obj = obj + "}";
                objects[i] = obj;
            }

            // Write header
            bw.write("ID,Name,Age,Marks");
            bw.newLine();

            // Process each JSON object
            for (String obj : objects) {
                obj = obj.replaceAll("[{}\"]", ""); // remove braces and quotes
                String[] fields = obj.split(",");
                int id = 0, age = 0, marks = 0;
                String name = "";
                for (String field : fields) {
                    String[] kv = field.split(":");
                    String key = kv[0].trim();
                    String value = kv[1].trim();
                    switch (key) {
                        case "id": id = Integer.parseInt(value); break;
                        case "name": name = value; break;
                        case "age": age = Integer.parseInt(value); break;
                        case "marks": marks = Integer.parseInt(value); break;
                    }
                }
                JsonManualStudentRecord student = new JsonManualStudentRecord(id, name, age, marks);
                bw.write(student.toCsvRow());
                bw.newLine();
            }

            System.out.println("CSV file created: " + csvFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CSV -> JSON
    public static void csvToJson(String csvFile, String jsonFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile))) {

            String line;
            boolean isHeader = true;
            List<JsonManualStudentRecord> students = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                students.add(JsonManualStudentRecord.fromCsvRow(line));
            }

            // Build JSON manually
            bw.write("[\n");
            for (int i = 0; i < students.size(); i++) {
                bw.write("  " + students.get(i).toJsonString());
                if (i != students.size() - 1) bw.write(",");
                bw.newLine();
            }
            bw.write("]");

            System.out.println("JSON file created: " + jsonFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String jsonInput = "students_manual_json_input.json";
        String csvOutput = "students_manual_from_json.csv";
        String jsonOutput = "students_manual_from_csv.json";

        // Convert JSON -> CSV
        jsonToCsv(jsonInput, csvOutput);

        // Convert CSV -> JSON
        csvToJson(csvOutput, jsonOutput);
    }
}
