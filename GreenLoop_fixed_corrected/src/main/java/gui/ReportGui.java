package gui;

import services.ReportService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.List;

public class ReportGui extends javax.swing.JFrame {

    private final ReportService service = new ReportService();
    private DefaultTableModel tableModel;

    public ReportGui() {
        initComponents();
        setTitle("GreenLoop – Generate Reports");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        btnMonthlySales = new javax.swing.JButton();
        btnLowStock = new javax.swing.JButton();
        btnOrderStatus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReport = new javax.swing.JTable();
        lblReportTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16));
        jLabel1.setForeground(new java.awt.Color(34, 139, 34));
        jLabel1.setText("Reports – GreenLoop");

        jLabel2.setText("Year:");

        tableModel = new DefaultTableModel(new Object[]{}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tblReport.setModel(tableModel);
        jScrollPane1.setViewportView(tblReport);

        lblReportTitle.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblReportTitle.setForeground(new java.awt.Color(34, 139, 34));
        lblReportTitle.setText("Select a report to generate");

        btnMonthlySales.setBackground(new java.awt.Color(102, 204, 102));
        btnMonthlySales.setText("Monthly Sales Report");
        btnMonthlySales.addActionListener(evt -> {
            try {
                int year = Integer.parseInt(txtYear.getText().trim());
                List<String[]> data = service.getMonthlySalesReport(year);
                tableModel.setColumnCount(0);
                tableModel.setRowCount(0);
                tableModel.addColumn("Month");
                tableModel.addColumn("Revenue (Rs.)");
                for (String[] row : data) tableModel.addRow(row);
                lblReportTitle.setText("Monthly Sales Report – " + year);
                if (data.isEmpty()) JOptionPane.showMessageDialog(this, "No sales data for " + year + ".");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Enter a valid year.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnLowStock.setBackground(new java.awt.Color(255, 204, 51));
        btnLowStock.setText("Low Stock Alert");
        btnLowStock.addActionListener(evt -> {
            List<String[]> data = service.getLowStockReport();
            tableModel.setColumnCount(0);
            tableModel.setRowCount(0);
            tableModel.addColumn("Product ID");
            tableModel.addColumn("Name");
            tableModel.addColumn("Stock Qty");
            tableModel.addColumn("Reorder Level");
            for (String[] row : data) tableModel.addRow(row);
            lblReportTitle.setText("Low Stock Alert Report");
            if (data.isEmpty()) JOptionPane.showMessageDialog(this, "All products are adequately stocked.");
        });

        btnOrderStatus.setBackground(new java.awt.Color(153, 204, 255));
        btnOrderStatus.setText("Order Status Summary");
        btnOrderStatus.addActionListener(evt -> {
            List<String[]> data = service.getOrderStatusSummary();
            tableModel.setColumnCount(0);
            tableModel.setRowCount(0);
            tableModel.addColumn("Status");
            tableModel.addColumn("Count");
            for (String[] row : data) tableModel.addRow(row);
            lblReportTitle.setText("Order Status Summary");
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup().addComponent(jLabel2).addGap(8).addComponent(txtYear, 80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMonthlySales).addGap(10)
                        .addComponent(btnLowStock).addGap(10)
                        .addComponent(btnOrderStatus))
                    .addComponent(lblReportTitle)
                    .addComponent(jScrollPane1, 600, 600, 600))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15).addComponent(jLabel1).addGap(15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(txtYear))
                .addGap(15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMonthlySales).addComponent(btnLowStock).addComponent(btnOrderStatus))
                .addGap(15)
                .addComponent(lblReportTitle)
                .addGap(10)
                .addComponent(jScrollPane1, 250, 250, 250)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLowStock;
    private javax.swing.JButton btnMonthlySales;
    private javax.swing.JButton btnOrderStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblReportTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReport;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
