package dao;

import Dbconnection.DBConnection;
import Dbconnection.EmailUtility;
import models.DeliveryAgent;
import jakarta.mail.MessagingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryAgentDB {

    private Connection conn = DBConnection.getConnection();

    public boolean addAgent(DeliveryAgent a) {
        String sql = "INSERT INTO delivery_agents (name, email, phone, vehicleType, vehicleNumber, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, a.getName());
            stmt.setString(2, a.getEmail());
            stmt.setString(3, a.getPhone());
            stmt.setString(4, a.getVehicleType());
            stmt.setString(5, a.getVehicleNumber());
            stmt.setString(6, a.getStatus());
            boolean result = stmt.executeUpdate() > 0;
            if (result) {
                try {
                    String subject = "Welcome to GreenLoop Delivery Team";
                    String body = "Hi " + a.getName() + ",\n\nYou have been successfully added as a delivery agent at GreenLoop.\n\nThank you!";
                    EmailUtility.sendEmail(a.getEmail(), subject, body);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAgent(DeliveryAgent a) {
        String sql = "UPDATE delivery_agents SET name=?, email=?, phone=?, vehicleType=?, vehicleNumber=?, status=? WHERE agentId=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, a.getName());
            stmt.setString(2, a.getEmail());
            stmt.setString(3, a.getPhone());
            stmt.setString(4, a.getVehicleType());
            stmt.setString(5, a.getVehicleNumber());
            stmt.setString(6, a.getStatus());
            stmt.setInt(7, a.getAgentId());
            boolean result = stmt.executeUpdate() > 0;
            if (result) {
                try {
                    String subject = "Your GreenLoop Profile Has Been Updated";
                    String body = "Hi " + a.getName() + ",\n\nYour delivery agent profile has been updated.\n\nThank you!";
                    EmailUtility.sendEmail(a.getEmail(), subject, body);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAgent(int agentId) {
        DeliveryAgent a = getAgentById(agentId);
        if (a == null) return false;

        String sql = "DELETE FROM delivery_agents WHERE agentId=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, agentId);
            boolean result = stmt.executeUpdate() > 0;
            if (result) {
                try {
                    String subject = "GreenLoop Agent Account Removed";
                    String body = "Hi " + a.getName() + ",\n\nYour delivery agent account has been removed from the GreenLoop system.\n\nThank you for your service!";
                    EmailUtility.sendEmail(a.getEmail(), subject, body);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<DeliveryAgent> getAllAgents() {
        List<DeliveryAgent> list = new ArrayList<>();
        String sql = "SELECT * FROM delivery_agents";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public DeliveryAgent getAgentById(int agentId) {
        String sql = "SELECT * FROM delivery_agents WHERE agentId=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, agentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private DeliveryAgent mapRow(ResultSet rs) throws SQLException {
        DeliveryAgent a = new DeliveryAgent();
        a.setAgentId(rs.getInt("agentId"));
        a.setName(rs.getString("name"));
        a.setEmail(rs.getString("email"));
        a.setPhone(rs.getString("phone"));
        a.setVehicleType(rs.getString("vehicleType"));
        a.setVehicleNumber(rs.getString("vehicleNumber"));
        a.setStatus(rs.getString("status"));
        return a;
    }
}
