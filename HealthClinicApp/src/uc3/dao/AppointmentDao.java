package uc3.dao;

import uc3.model.Appointment;
import uc1.dao.DbConnection;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDao {
    private Connection conn;

    public AppointmentDao() {
        try {
            conn = DbConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot connect to database");
        }
    }

    public boolean addAppointment(Appointment appt) {
        String sql = "INSERT INTO appointments(patient_id, doctor_id, appointment_date, appointment_time, status) VALUES(?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, appt.getPatientId());
            ps.setInt(2, appt.getDoctorId());
            ps.setDate(3, Date.valueOf(appt.getAppointmentDate()));
            ps.setTime(4, Time.valueOf(appt.getAppointmentTime()));
            ps.setString(5, appt.getStatus());
            int rows = ps.executeUpdate();
            if(rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()) appt.setId(rs.getInt(1));
                return true;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while(rs.next()) {
                Appointment appt = new Appointment();
                appt.setId(rs.getInt("id"));
                appt.setPatientId(rs.getInt("patient_id"));
                appt.setDoctorId(rs.getInt("doctor_id"));
                appt.setAppointmentDate(rs.getDate("appointment_date").toLocalDate());
                appt.setAppointmentTime(rs.getTime("appointment_time").toLocalTime());
                appt.setStatus(rs.getString("status"));
                list.add(appt);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
