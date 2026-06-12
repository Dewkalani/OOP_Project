package dao;

import Dbconnection.DBConnection;
import Dbconnection.EmailUtility;
import models.Order;
import models.Client;
import models.DeliveryAgent;
import jakarta.mail.MessagingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDB {

    private Connection conn = DBConnection.getConnection();

    public boolean addOrder(Order o) {
        String sql = "INSERT INTO orders (clientId, orderDate, totalAmount, status, deliveryAddress, agentId) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, o.getClientId());
            stmt.setDate(2, new java.sql.Date(o.getOrderDate().getTime()));
            stmt.setDouble(3, o.getTotalAmount());
            stmt.setString(4, o.getStatus());
            stmt.setString(5, o.getDeliveryAddress());
            stmt.setInt(6, o.getAgentId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateOrder(Order o) {
        String sql = "UPDATE orders SET clientId=?, orderDate=?, totalAmount=?, status=?, deliveryAddress=?, agentId=? WHERE orderId=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, o.getClientId());
            stmt.setDate(2, new java.sql.Date(o.getOrderDate().getTime()));
            stmt.setDouble(3, o.getTotalAmount());
            stmt.setString(4, o.getStatus());
            stmt.setString(5, o.getDeliveryAddress());
            stmt.setInt(6, o.getAgentId());
            stmt.setInt(7, o.getOrderId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteOrder(int orderId) {
        String sql = "DELETE FROM orders WHERE orderId=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Dispatches an order: updates status to Dispatched, emails the client,
     * and emails the assigned delivery agent.
     */
    public boolean dispatchOrder(int orderId, String clientEmail, String clientName,
                                  String agentEmail, String agentName) {
        String sql = "UPDATE orders SET status='Dispatched' WHERE orderId=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            boolean result = stmt.executeUpdate() > 0;
            if (result) {
                // Email to client
                try {
                    String clientSubject = "Your GreenLoop Order Has Been Dispatched!";
                    String clientBody = "Dear " + clientName + ",\n\n"
                            + "We are pleased to inform you that your order #" + orderId + " has been dispatched.\n"
                            + "Our delivery agent will reach you soon.\n\n"
                            + "Thank you for choosing GreenLoop!\n"
                            + "GreenLoop Eco-Packaging";
                    EmailUtility.sendEmail(clientEmail, clientSubject, clientBody);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                // Email to delivery agent
                try {
                    String agentSubject = "New Delivery Assignment – Order #" + orderId;
                    String agentBody = "Dear " + agentName + ",\n\n"
                            + "You have been assigned to deliver Order #" + orderId + ".\n"
                            + "Please check the system for delivery details.\n\n"
                            + "GreenLoop Eco-Packaging";
                    EmailUtility.sendEmail(agentEmail, agentSubject, agentBody);
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

    public List<Order> getAllOrders() {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Order getOrderById(int orderId) {
        String sql = "SELECT * FROM orders WHERE orderId=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Order mapRow(ResultSet rs) throws SQLException {
        Order o = new Order();
        o.setOrderId(rs.getInt("orderId"));
        o.setClientId(rs.getInt("clientId"));
        o.setOrderDate(rs.getDate("orderDate"));
        o.setTotalAmount(rs.getDouble("totalAmount"));
        o.setStatus(rs.getString("status"));
        o.setDeliveryAddress(rs.getString("deliveryAddress"));
        o.setAgentId(rs.getInt("agentId"));
        return o;
    }
}
