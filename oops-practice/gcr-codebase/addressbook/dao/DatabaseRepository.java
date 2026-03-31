package dao;

import model.ContactPerson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepository {

    private static final String DB_URL = "jdbc:sqlite:addressbook.db";

    public DatabaseRepository() {
        createTableIfNotExists();
    }

    private void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS contacts (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "firstName TEXT, lastName TEXT, address TEXT, city TEXT," +
                "state TEXT, zip TEXT, phoneNumber TEXT, email TEXT" +
                ");";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("DB table creation error: " + e.getMessage());
        }
    }

    public void saveContacts(List<ContactPerson> contacts) {
        String sql = "INSERT INTO contacts(firstName,lastName,address,city,state,zip,phoneNumber,email) " +
                "VALUES(?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (ContactPerson c : contacts) {
                pstmt.setString(1, c.getFirstName());
                pstmt.setString(2, c.getLastName());
                pstmt.setString(3, c.getAddress());
                pstmt.setString(4, c.getCity());
                pstmt.setString(5, c.getState());
                pstmt.setString(6, c.getZip());
                pstmt.setString(7, c.getPhoneNumber()); // <- corrected
                pstmt.setString(8, c.getEmail());       // <- make sure getter matches
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            System.out.println("Contacts saved to Database successfully!");
        } catch (SQLException e) {
            System.out.println("Database save error: " + e.getMessage());
        }
    }

    public List<ContactPerson> loadContacts() {
        List<ContactPerson> contacts = new ArrayList<>();
        String sql = "SELECT firstName,lastName,address,city,state,zip,phoneNumber,email FROM contacts";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ContactPerson c = new ContactPerson(
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zip"),
                        rs.getString("phoneNumber"), // <- corrected
                        rs.getString("email")        // <- make sure getter matches
                );
                contacts.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Database load error: " + e.getMessage());
        }
        return contacts;
    }
}
