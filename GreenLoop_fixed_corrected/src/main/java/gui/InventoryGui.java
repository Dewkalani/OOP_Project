package gui;

import models.Product;
import services.ProductService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class InventoryGui extends javax.swing.JFrame {

    private final ProductService service = new ProductService();
    private DefaultTableModel tableModel;

    public InventoryGui() {
        initComponents();
        setTitle("GreenLoop – Stock / Inventory Management");
        setLocationRelativeTo(null);
        loadTable();
    }

    private void loadTable() {
        tableModel.setRowCount(0);
        List<Product> products = service.getAllProducts();
        for (Product p : products) {
            String alert = (p.getStockQuantity() <= p.getReorderLevel()) ? "LOW STOCK" : "OK";
            tableModel.addRow(new Object[]{
                p.getProductId(), p.getName(), p.getStockQuantity(), p.getReorderLevel(), alert
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtProductId = new javax.swing.JTextField();
        txtQtyToAdd = new javax.swing.JTextField();
        btnStockIn = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnLowStock = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventory = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16));
        jLabel1.setForeground(new java.awt.Color(34, 139, 34));
        jLabel1.setText("Stock / Inventory Management");

        jLabel2.setText("Product ID:");
        jLabel3.setText("Quantity to Add:");

        tableModel = new DefaultTableModel(
            new Object[]{"ID", "Name", "Stock Qty", "Reorder Level", "Status"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tblInventory.setModel(tableModel);
        tblInventory.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblInventory.getSelectionModel().addListSelectionListener(e -> {
            int row = tblInventory.getSelectedRow();
            if (row >= 0) txtProductId.setText(tableModel.getValueAt(row, 0).toString());
        });
        jScrollPane1.setViewportView(tblInventory);

        btnStockIn.setBackground(new java.awt.Color(102, 204, 102));
        btnStockIn.setText("Stock In (Add Qty)");
        btnStockIn.addActionListener(evt -> {
            String idStr = txtProductId.getText().trim();
            String qtyStr = txtQtyToAdd.getText().trim();
            if (idStr.isEmpty() || qtyStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter Product ID and quantity.");
                return;
            }
            try {
                int id = Integer.parseInt(idStr);
                int qty = Integer.parseInt(qtyStr);
                if (qty <= 0) { JOptionPane.showMessageDialog(this, "Quantity must be positive."); return; }
                if (service.updateStock(id, qty)) {
                    JOptionPane.showMessageDialog(this, "Stock updated successfully!");
                    txtProductId.setText(""); txtQtyToAdd.setText("");
                    loadTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update stock.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Enter valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(evt -> loadTable());

        btnLowStock.setBackground(new java.awt.Color(255, 204, 51));
        btnLowStock.setText("Show Low Stock Only");
        btnLowStock.addActionListener(evt -> {
            tableModel.setRowCount(0);
            List<Product> low = service.getLowStockProducts();
            if (low.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No low-stock products at the moment.");
                loadTable();
                return;
            }
            for (Product p : low) {
                tableModel.addRow(new Object[]{
                    p.getProductId(), p.getName(), p.getStockQuantity(), p.getReorderLevel(), "LOW STOCK"
                });
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel2).addComponent(jLabel3))
                        .addGap(10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProductId, 160, 160, 160)
                            .addComponent(txtQtyToAdd, 160, 160, 160)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStockIn).addGap(10)
                        .addComponent(btnRefresh).addGap(10)
                        .addComponent(btnLowStock))
                    .addComponent(jScrollPane1, 620, 620, 620))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15).addComponent(jLabel1).addGap(15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(txtProductId))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(txtQtyToAdd))
                .addGap(15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStockIn).addComponent(btnRefresh).addComponent(btnLowStock))
                .addGap(15)
                .addComponent(jScrollPane1, 220, 220, 220)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLowStock;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnStockIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInventory;
    private javax.swing.JTextField txtProductId;
    private javax.swing.JTextField txtQtyToAdd;
    // End of variables declaration//GEN-END:variables
}
