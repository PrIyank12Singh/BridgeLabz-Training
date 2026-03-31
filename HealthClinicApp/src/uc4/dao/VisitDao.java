package uc4.dao;

import uc4.model.Visit;
import uc4.model.Prescription;
import uc1.dao.DbConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisitDao {
    private Connection conn;

    public VisitDao() {
        try {
            conn = DbConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot connect to database");
        }
    }

    public boolean addVisit(Visit v) {
        String sql = "INSERT INTO visits(appointment_id, doctor_id, patient_id, visit_date, diagnosis, notes) VALUES(?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, v.getAppointmentId());
            ps.setInt(2, v.getDoctorId());
            ps.setInt(3, v.getPatientId());
            ps.setDate(4, Date.valueOf(v.getVisitDate()));
            ps.setString(5, v.getDiagnosis());
            ps.setString(6, v.getNotes());
            int rows = ps.executeUpdate();
            if(rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()) v.setId(rs.getInt(1));
                return true;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addPrescription(Prescription p) {
        String sql = "INSERT INTO prescriptions(visit_id, medicine, dose, duration) VALUES(?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, p.getVisitId());
            ps.setString(2, p.getMedicine());
            ps.setString(3, p.getDose());
            ps.setString(4, p.getDuration());
            int rows = ps.executeUpdate();
            if(rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()) p.setId(rs.getInt(1));
                return true;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Visit> getAllVisits() {
        List<Visit> list = new ArrayList<>();
        String sql = "SELECT * FROM visits";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while(rs.next()) {
                Visit v = new Visit();
                v.setId(rs.getInt("id"));
                v.setAppointmentId(rs.getInt("appointment_id"));
                v.setDoctorId(rs.getInt("doctor_id"));
                v.setPatientId(rs.getInt("patient_id"));
                v.setVisitDate(rs.getDate("visit_date").toLocalDate());
                v.setDiagnosis(rs.getString("diagnosis"));
                v.setNotes(rs.getString("notes"));
                list.add(v);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
