package gui;

import models.Client;
import services.ClientService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ClientGui extends javax.swing.JFrame {

    private final ClientService service = new ClientService();
    private DefaultTableModel tableModel;

    public ClientGui() {
        initComponents();
        setTitle("GreenLoop – Manage Clients");
        setLocationRelativeTo(null);
        loadTable();
    }

    private void loadTable() {
        tableModel.setRowCount(0);
        List<Client> clients = service.getAllClients();
        for (Client c : clients) {
            tableModel.addRow(new Object[]{
                c.getClientId(), c.getName(), c.getEmail(), c.getPhone(), c.getAddress(), c.getBusinessType()
            });
        }
    }

    private void clearFields() {
        txtClientId.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
        txtBusinessType.setText("");
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
        txtClientId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtBusinessType = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClients = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16));
        jLabel1.setForeground(new java.awt.Color(34, 139, 34));
        jLabel1.setText("Client Management");

        jLabel2.setText("Client ID:");
        jLabel3.setText("Name:");
        jLabel4.setText("Email:");
        jLabel5.setText("Phone:");
        jLabel6.setText("Address:");
        jLabel7.setText("Business Type:");

        tableModel = new DefaultTableModel(
            new Object[]{"ID", "Name", "Email", "Phone", "Address", "Business Type"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tblClients.setModel(tableModel);
        tblClients.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblClients.getSelectionModel().addListSelectionListener(e -> {
            int row = tblClients.getSelectedRow();
            if (row >= 0) {
                txtClientId.setText(tableModel.getValueAt(row, 0).toString());
                txtName.setText(tableModel.getValueAt(row, 1).toString());
                txtEmail.setText(tableModel.getValueAt(row, 2).toString());
                txtPhone.setText(tableModel.getValueAt(row, 3).toString());
                txtAddress.setText(tableModel.getValueAt(row, 4).toString());
                txtBusinessType.setText(tableModel.getValueAt(row, 5).toString());
            }
        });
        jScrollPane1.setViewportView(tblClients);

        btnAdd.setBackground(new java.awt.Color(102, 204, 102));
        btnAdd.setText("Add Client");
        btnAdd.addActionListener(evt -> btnAddActionPerformed(evt));

        btnUpdate.setBackground(new java.awt.Color(51, 153, 255));
        btnUpdate.setForeground(java.awt.Color.WHITE);
        btnUpdate.setText("Update Client");
        btnUpdate.addActionListener(evt -> btnUpdateActionPerformed(evt));

        btnDelete.setBackground(new java.awt.Color(255, 102, 102));
        btnDelete.setForeground(java.awt.Color.WHITE);
        btnDelete.setText("Delete Client");
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
                            .addComponent(jLabel5).addComponent(jLabel6).addComponent(jLabel7))
                        .addGap(10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtClientId, 200, 200, 200)
                            .addComponent(txtName, 200, 200, 200)
                            .addComponent(txtEmail, 200, 200, 200)
                            .addComponent(txtPhone, 200, 200, 200)
                            .addComponent(txtAddress, 200, 200, 200)
                            .addComponent(txtBusinessType, 200, 200, 200)))
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
                .addGap(15).addComponent(jLabel1).addGap(15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(txtClientId))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(txtName))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4).addComponent(txtEmail))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5).addComponent(txtPhone))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6).addComponent(txtAddress))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7).addComponent(txtBusinessType))
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
        Client c = new Client();
        c.setName(txtName.getText().trim());
        c.setEmail(txtEmail.getText().trim());
        c.setPhone(txtPhone.getText().trim());
        c.setAddress(txtAddress.getText().trim());
        c.setBusinessType(txtBusinessType.getText().trim());
        if (service.addClient(c)) {
            JOptionPane.showMessageDialog(this, "Client added successfully!");
            clearFields(); loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add client.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtClientId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select a client from the table first."); return;
        }
        Client c = new Client();
        c.setClientId(Integer.parseInt(txtClientId.getText().trim()));
        c.setName(txtName.getText().trim());
        c.setEmail(txtEmail.getText().trim());
        c.setPhone(txtPhone.getText().trim());
        c.setAddress(txtAddress.getText().trim());
        c.setBusinessType(txtBusinessType.getText().trim());
        if (service.updateClient(c)) {
            JOptionPane.showMessageDialog(this, "Client updated successfully!");
            clearFields(); loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update client.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtClientId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select a client from the table first."); return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Delete this client?");
        if (confirm == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(txtClientId.getText().trim());
            if (service.deleteClient(id)) {
                JOptionPane.showMessageDialog(this, "Client deleted successfully!");
                clearFields(); loadTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete client.", "Error", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClients;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBusinessType;
    private javax.swing.JTextField txtClientId;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
