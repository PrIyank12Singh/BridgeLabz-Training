package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbToJsonReportApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "root";

        List<Map<String, Object>> records = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("id", rs.getInt("id"));
                row.put("name", rs.getString("name"));
                row.put("email", rs.getString("email"));
                row.put("age", rs.getInt("age"));
                records.add(row);
            }

            ObjectMapper mapper = new ObjectMapper();
            String jsonReport = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(records);
            System.out.println(jsonReport);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
