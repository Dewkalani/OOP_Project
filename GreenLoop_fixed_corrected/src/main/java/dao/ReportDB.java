package dao;

import Dbconnection.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportDB {

    private Connection conn = DBConnection.getConnection();

    /**
     * Returns monthly revenue grouped by month for the current year.
     * Returns rows: [month_name, revenue]
     */
    public List<String[]> getMonthlySalesReport(int year) {
        List<String[]> rows = new ArrayList<>();
        String sql = "SELECT MONTHNAME(orderDate) AS month, SUM(totalAmount) AS revenue "
                   + "FROM orders WHERE YEAR(orderDate)=? AND status != 'Cancelled' "
                   + "GROUP BY MONTH(orderDate) ORDER BY MONTH(orderDate)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, year);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    rows.add(new String[]{rs.getString("month"), String.valueOf(rs.getDouble("revenue"))});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * Returns all products where stockQuantity <= reorderLevel (low stock alert).
     * Returns rows: [productId, name, stockQuantity, reorderLevel]
     */
    public List<String[]> getLowStockReport() {
        List<String[]> rows = new ArrayList<>();
        String sql = "SELECT productId, name, stockQuantity, reorderLevel FROM products WHERE stockQuantity <= reorderLevel";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                rows.add(new String[]{
                    rs.getString("productId"),
                    rs.getString("name"),
                    rs.getString("stockQuantity"),
                    rs.getString("reorderLevel")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * Returns order count per status.
     * Returns rows: [status, count]
     */
    public List<String[]> getOrderStatusSummary() {
        List<String[]> rows = new ArrayList<>();
        String sql = "SELECT status, COUNT(*) AS cnt FROM orders GROUP BY status";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                rows.add(new String[]{rs.getString("status"), rs.getString("cnt")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
