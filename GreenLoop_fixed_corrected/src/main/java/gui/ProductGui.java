package gui;

import models.Product;
import services.ProductService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ProductGui extends javax.swing.JFrame {

    private final ProductService service = new ProductService();
    private DefaultTableModel tableModel;

    public ProductGui() {
        initComponents();
        setTitle("GreenLoop – Manage Product Catalogue");
        setLocationRelativeTo(null);
        loadTable();
    }

    private void loadTable() {
        tableModel.setRowCount(0);
        List<Product> products = service.getAllProducts();
        for (Product p : products) {
            tableModel.addRow(new Object[]{
                p.getProductId(), p.getName(), p.getDescription(),
                p.getPrice(), p.getEcoRating(), p.getStockQuantity(), p.getReorderLevel()
            });
        }
    }

    private void clearFields() {
        txtProductId.setText("");
        txtName.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
        txtEcoRating.setText("");
        txtStock.setText("");
        txtReorder.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtProductId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtEcoRating = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtReorder = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16));
        jLabel1.setForeground(new java.awt.Color(34, 139, 34));
        jLabel1.setText("Product Catalogue Management");

        jLabel2.setText("Product ID:");
        jLabel3.setText("Name:");
        jLabel4.setText("Description:");
        jLabel5.setText("Price (Rs.):");
        jLabel6.setText("Eco Rating:");
        jLabel7.setText("Stock Qty:");
        jLabel8.setText("Reorder Level:");

        tableModel = new DefaultTableModel(
            new Object[]{"ID", "Name", "Description", "Price", "Eco Rating", "Stock Qty", "Reorder Level"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tblProducts.setModel(tableModel);
        tblProducts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProducts.getSelectionModel().addListSelectionListener(e -> {
            int row = tblProducts.getSelectedRow();
            if (row >= 0) {
                txtProductId.setText(tableModel.getValueAt(row, 0).toString());
                txtName.setText(tableModel.getValueAt(row, 1).toString());
                txtDescription.setText(tableModel.getValueAt(row, 2).toString());
                txtPrice.setText(tableModel.getValueAt(row, 3).toString());
                txtEcoRating.setText(tableModel.getValueAt(row, 4).toString());
                txtStock.setText(tableModel.getValueAt(row, 5).toString());
                txtReorder.setText(tableModel.getValueAt(row, 6).toString());
            }
        });
        jScrollPane1.setViewportView(tblProducts);

        btnAdd.setBackground(new java.awt.Color(102, 204, 102));
        btnAdd.setText("Add Product");
        btnAdd.addActionListener(evt -> btnAddActionPerformed(evt));

        btnUpdate.setBackground(new java.awt.Color(51, 153, 255));
        btnUpdate.setForeground(java.awt.Color.WHITE);
        btnUpdate.setText("Update Product");
        btnUpdate.addActionListener(evt -> btnUpdateActionPerformed(evt));

        btnDelete.setBackground(new java.awt.Color(255, 102, 102));
        btnDelete.setForeground(java.awt.Color.WHITE);
        btnDelete.setText("Delete Product");
        btnDelete.addActionListener(evt -> btnDeleteActionPerformed(evt));

        btnClear.setText("Clear");
        btnClear.addActionListener(evt -> clearFields());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2).addComponent(jLabel3).addComponent(jLabel4)
                            .addComponent(jLabel5).addComponent(jLabel6).addComponent(jLabel7).addComponent(jLabel8))
                        .addGap(10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProductId, 180, 180, 180)
                            .addComponent(txtName, 180, 180, 180)
                            .addComponent(txtDescription, 180, 180, 180)
                            .addComponent(txtPrice, 180, 180, 180)
                            .addComponent(txtEcoRating, 180, 180, 180)
                            .addComponent(txtStock, 180, 180, 180)
                            .addComponent(txtReorder, 180, 180, 180)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd).addGap(10)
                        .addComponent(btnUpdate).addGap(10)
                        .addComponent(btnDelete).addGap(10)
                        .addComponent(btnClear))
                    .addComponent(jScrollPane1, 650, 650, 650))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15)
                .addComponent(jLabel1)
                .addGap(15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(txtProductId))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(txtName))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4).addComponent(txtDescription))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5).addComponent(txtPrice))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6).addComponent(txtEcoRating))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7).addComponent(txtStock))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel8).addComponent(txtReorder))
                .addGap(15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd).addComponent(btnUpdate).addComponent(btnDelete).addComponent(btnClear))
                .addGap(15)
                .addComponent(jScrollPane1, 200, 200, 200)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Product p = new Product();
            p.setName(txtName.getText().trim());
            p.setDescription(txtDescription.getText().trim());
            p.setPrice(Double.parseDouble(txtPrice.getText().trim()));
            p.setEcoRating(txtEcoRating.getText().trim());
            p.setStockQuantity(Integer.parseInt(txtStock.getText().trim()));
            p.setReorderLevel(Integer.parseInt(txtReorder.getText().trim()));
            if (service.addProduct(p)) {
                JOptionPane.showMessageDialog(this, "Product added successfully!");
                clearFields();
                loadTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add product.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for Price, Stock Qty, and Reorder Level.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (txtProductId.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Select a product from the table first.");
                return;
            }
            Product p = new Product();
            p.setProductId(Integer.parseInt(txtProductId.getText().trim()));
            p.setName(txtName.getText().trim());
            p.setDescription(txtDescription.getText().trim());
            p.setPrice(Double.parseDouble(txtPrice.getText().trim()));
            p.setEcoRating(txtEcoRating.getText().trim());
            p.setStockQuantity(Integer.parseInt(txtStock.getText().trim()));
            p.setReorderLevel(Integer.parseInt(txtReorder.getText().trim()));
            if (service.updateProduct(p)) {
                JOptionPane.showMessageDialog(this, "Product updated successfully!");
                clearFields();
                loadTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update product.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtProductId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select a product from the table first.");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this product?");
        if (confirm == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(txtProductId.getText().trim());
            if (service.deleteProduct(id)) {
                JOptionPane.showMessageDialog(this, "Product deleted successfully!");
                clearFields();
                loadTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete product.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtEcoRating;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductId;
    private javax.swing.JTextField txtReorder;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
