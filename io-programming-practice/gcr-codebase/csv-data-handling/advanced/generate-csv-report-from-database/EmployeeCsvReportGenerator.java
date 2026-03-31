import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeCsvReportGenerator {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database"; // Replace with your DB URL
        String username = "your_username";                              // Replace with DB username
        String password = "your_password";                              // Replace with DB password

        String outputFile = "employee_db_report.csv";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement();
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String query = "SELECT employee_id, name, department, salary FROM employees"; // Your table
            ResultSet rs = stmt.executeQuery(query);

            // Write header
            bw.write("Employee ID,Name,Department,Salary");
            bw.newLine();

            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                double salary = rs.getDouble("salary");

                EmployeeDbRecord employee = new EmployeeDbRecord(id, name, dept, salary);

                // Write row to CSV
                bw.write(employee.toCsvRow());
                bw.newLine();
            }

            System.out.println("CSV report generated successfully: " + outputFile);

        } catch (Exception e) {
            System.out.println("Error generating CSV report: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
