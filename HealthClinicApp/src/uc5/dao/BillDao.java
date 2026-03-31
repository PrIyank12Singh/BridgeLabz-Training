package uc5.dao;

import uc5.model.Bill;
import uc1.dao.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDao {
    private Connection conn;

    public BillDao() {
        try {
            conn = DbConnection.getConnection();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot connect to DB");
        }
    }

    public boolean addBill(Bill b) {
        String sql = "INSERT INTO bills(visit_id, amount, status) VALUES(?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, b.getVisitId());
            ps.setDouble(2, b.getAmount());
            ps.setString(3, b.getStatus());
            int rows = ps.executeUpdate();
            if(rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()) b.setId(rs.getInt(1));
                return true;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Bill> getAllBills() {
        List<Bill> list = new ArrayList<>();
        String sql = "SELECT * FROM bills";
        try(Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while(rs.next()) {
                Bill b = new Bill();
                b.setId(rs.getInt("id"));
                b.setVisitId(rs.getInt("visit_id"));
                b.setAmount(rs.getDouble("amount"));
                b.setStatus(rs.getString("status"));
                list.add(b);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean markPaid(int billId) {
        String sql = "UPDATE bills SET status='PAID' WHERE id=?";
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, billId);
            return ps.executeUpdate() > 0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
