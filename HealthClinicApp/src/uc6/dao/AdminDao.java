package uc6.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import uc1.dao.DbConnection;

public class AdminDao {

    public boolean addSpecialty(String specialtyName) {
        String sql = "INSERT INTO specialties(name) VALUES(?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, specialtyName);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Additional UC-6 methods (delete/update specialty, etc.) can go here
}
