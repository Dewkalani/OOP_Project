package gui;

import models.DeliveryAgent;
import services.DeliveryAgentService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class DeliveryAgentGui extends javax.swing.JFrame {

    private final DeliveryAgentService service = new DeliveryAgentService();
    private DefaultTableModel tableModel;

    public DeliveryAgentGui() {
        initComponents();
        setTitle("GreenLoop – Manage Delivery Agents");
        setLocationRelativeTo(null);
        loadTable();
    }

    private void loadTable() {
        tableModel.setRowCount(0);
        List<DeliveryAgent> agents = service.getAllAgents();
        for (DeliveryAgent a : agents) {
            tableModel.addRow(new Object[]{
                a.getAgentId(), a.getName(), a.getEmail(), a.getPhone(),
                a.getVehicleType(), a.getVehicleNumber(), a.getStatus()
            });
        }
    }

    private void clearFields() {
        txtAgentId.setText(""); txtName.setText(""); txtEmail.setText("");
        txtPhone.setText(""); txtVehicleType.setText(""); txtVehicleNumber.setText("");
        cmbStatus.setSelectedIndex(0);
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
        txtAgentId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtVehicleType = new javax.swing.JTextField();
        txtVehicleNumber = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox<>(new String[]{"Available", "On Delivery", "Off Duty"});
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAgents = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16));
        jLabel1.setForeground(new java.awt.Color(34, 139, 34));
        jLabel1.setText("Delivery Agent Management");

        jLabel2.setText("Agent ID:");
        jLabel3.setText("Name:");
        jLabel4.setText("Email:");
        jLabel5.setText("Phone:");
        jLabel6.setText("Vehicle Type:");
        jLabel7.setText("Vehicle No:");
        jLabel8.setText("Status:");

        tableModel = new DefaultTableModel(
            new Object[]{"ID", "Name", "Email", "Phone", "Vehicle Type", "Vehicle No", "Status"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tblAgents.setModel(tableModel);
        tblAgents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblAgents.getSelectionModel().addListSelectionListener(e -> {
            int row = tblAgents.getSelectedRow();
            if (row >= 0) {
                txtAgentId.setText(tableModel.getValueAt(row, 0).toString());
                txtName.setText(tableModel.getValueAt(row, 1).toString());
                txtEmail.setText(tableModel.getValueAt(row, 2).toString());
                txtPhone.setText(tableModel.getValueAt(row, 3).toString());
                txtVehicleType.setText(tableModel.getValueAt(row, 4).toString());
                txtVehicleNumber.setText(tableModel.getValueAt(row, 5).toString());
                cmbStatus.setSelectedItem(tableModel.getValueAt(row, 6).toString());
            }
        });
        jScrollPane1.setViewportView(tblAgents);

        btnAdd.setBackground(new java.awt.Color(102, 204, 102));
        btnAdd.setText("Add Agent");
        btnAdd.addActionListener(evt -> btnAddActionPerformed(evt));

        btnUpdate.setBackground(new java.awt.Color(51, 153, 255));
        btnUpdate.setForeground(java.awt.Color.WHITE);
        btnUpdate.setText("Update Agent");
        btnUpdate.addActionListener(evt -> btnUpdateActionPerformed(evt));

        btnDelete.setBackground(new java.awt.Color(255, 102, 102));
        btnDelete.setForeground(java.awt.Color.WHITE);
        btnDelete.setText("Delete Agent");
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
                            .addComponent(txtAgentId, 200, 200, 200)
                            .addComponent(txtName, 200, 200, 200)
                            .addComponent(txtEmail, 200, 200, 200)
                            .addComponent(txtPhone, 200, 200, 200)
                            .addComponent(txtVehicleType, 200, 200, 200)
                            .addComponent(txtVehicleNumber, 200, 200, 200)
                            .addComponent(cmbStatus, 200, 200, 200)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd).addGap(10)
                        .addComponent(btnUpdate).addGap(10)
                        .addComponent(btnDelete).addGap(10)
                        .addComponent(btnClear))
                    .addComponent(jScrollPane1, 700, 700, 700))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15).addComponent(jLabel1).addGap(15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(txtAgentId))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(txtName))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4).addComponent(txtEmail))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5).addComponent(txtPhone))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6).addComponent(txtVehicleType))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7).addComponent(txtVehicleNumber))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel8).addComponent(cmbStatus))
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
        DeliveryAgent a = new DeliveryAgent();
        a.setName(txtName.getText().trim());
        a.setEmail(txtEmail.getText().trim());
        a.setPhone(txtPhone.getText().trim());
        a.setVehicleType(txtVehicleType.getText().trim());
        a.setVehicleNumber(txtVehicleNumber.getText().trim());
        a.setStatus(cmbStatus.getSelectedItem().toString());
        if (service.addAgent(a)) {
            JOptionPane.showMessageDialog(this, "Agent added! Email notification sent.");
            clearFields(); loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add agent.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtAgentId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select an agent from the table first."); return;
        }
        DeliveryAgent a = new DeliveryAgent();
        a.setAgentId(Integer.parseInt(txtAgentId.getText().trim()));
        a.setName(txtName.getText().trim());
        a.setEmail(txtEmail.getText().trim());
        a.setPhone(txtPhone.getText().trim());
        a.setVehicleType(txtVehicleType.getText().trim());
        a.setVehicleNumber(txtVehicleNumber.getText().trim());
        a.setStatus(cmbStatus.getSelectedItem().toString());
        if (service.updateAgent(a)) {
            JOptionPane.showMessageDialog(this, "Agent updated! Email notification sent.");
            clearFields(); loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update agent.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtAgentId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select an agent from the table first."); return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Delete this agent?");
        if (confirm == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(txtAgentId.getText().trim());
            if (service.deleteAgent(id)) {
                JOptionPane.showMessageDialog(this, "Agent deleted! Email notification sent.");
                clearFields(); loadTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete agent.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAgents;
    private javax.swing.JTextField txtAgentId;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtVehicleNumber;
    private javax.swing.JTextField txtVehicleType;
    // End of variables declaration//GEN-END:variables
}
