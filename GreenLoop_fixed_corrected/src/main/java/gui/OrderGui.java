package gui;

import models.Order;
import services.OrderService;
import services.ClientService;
import services.DeliveryAgentService;
import models.Client;
import models.DeliveryAgent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.List;

public class OrderGui extends javax.swing.JFrame {

    private final OrderService orderService = new OrderService();
    private final ClientService clientService = new ClientService();
    private final DeliveryAgentService agentService = new DeliveryAgentService();
    private DefaultTableModel tableModel;

    public OrderGui() {
        initComponents();
        setTitle("GreenLoop – Manage Orders");
        setLocationRelativeTo(null);
        loadTable();
    }

    private void loadTable() {
        tableModel.setRowCount(0);
        List<Order> orders = orderService.getAllOrders();
        for (Order o : orders) {
            Client c = clientService.getClientById(o.getClientId());
            String clientName = (c != null) ? c.getName() : "ID:" + o.getClientId();
            DeliveryAgent a = (o.getAgentId() > 0) ? agentService.getAgentById(o.getAgentId()) : null;
            String agentName = (a != null) ? a.getName() : "Not Assigned";
            tableModel.addRow(new Object[]{
                o.getOrderId(), clientName, o.getOrderDate(), o.getTotalAmount(),
                o.getStatus(), o.getDeliveryAddress(), agentName
            });
        }
    }

    private void clearFields() {
        txtOrderId.setText(""); txtClientId.setText(""); txtTotalAmount.setText("");
        cmbStatus.setSelectedIndex(0); txtDeliveryAddress.setText(""); txtAgentId.setText("");
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
        txtOrderId = new javax.swing.JTextField();
        txtClientId = new javax.swing.JTextField();
        txtTotalAmount = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox<>(new String[]{"Pending", "Processing", "Dispatched", "Delivered", "Cancelled"});
        txtDeliveryAddress = new javax.swing.JTextField();
        txtAgentId = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnDispatch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16));
        jLabel1.setForeground(new java.awt.Color(34, 139, 34));
        jLabel1.setText("Order Management");

        jLabel2.setText("Order ID:");
        jLabel3.setText("Client ID:");
        jLabel4.setText("Total Amount (Rs.):");
        jLabel5.setText("Status:");
        jLabel6.setText("Delivery Address:");
        jLabel7.setText("Agent ID (optional):");

        tableModel = new DefaultTableModel(
            new Object[]{"Order ID", "Client", "Date", "Total (Rs.)", "Status", "Address", "Agent"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tblOrders.setModel(tableModel);
        tblOrders.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblOrders.getSelectionModel().addListSelectionListener(e -> {
            int row = tblOrders.getSelectedRow();
            if (row >= 0) {
                txtOrderId.setText(tableModel.getValueAt(row, 0).toString());
                cmbStatus.setSelectedItem(tableModel.getValueAt(row, 4).toString());
                txtDeliveryAddress.setText(tableModel.getValueAt(row, 5).toString());
            }
        });
        jScrollPane1.setViewportView(tblOrders);

        btnAdd.setBackground(new java.awt.Color(102, 204, 102));
        btnAdd.setText("Create Order");
        btnAdd.addActionListener(evt -> btnAddActionPerformed(evt));

        btnUpdate.setBackground(new java.awt.Color(51, 153, 255));
        btnUpdate.setForeground(java.awt.Color.WHITE);
        btnUpdate.setText("Update Order");
        btnUpdate.addActionListener(evt -> btnUpdateActionPerformed(evt));

        btnDelete.setBackground(new java.awt.Color(255, 102, 102));
        btnDelete.setForeground(java.awt.Color.WHITE);
        btnDelete.setText("Delete Order");
        btnDelete.addActionListener(evt -> btnDeleteActionPerformed(evt));

        btnDispatch.setBackground(new java.awt.Color(255, 153, 0));
        btnDispatch.setForeground(java.awt.Color.WHITE);
        btnDispatch.setText("Dispatch + Email");
        btnDispatch.addActionListener(evt -> btnDispatchActionPerformed(evt));

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
                            .addComponent(txtOrderId, 200, 200, 200)
                            .addComponent(txtClientId, 200, 200, 200)
                            .addComponent(txtTotalAmount, 200, 200, 200)
                            .addComponent(cmbStatus, 200, 200, 200)
                            .addComponent(txtDeliveryAddress, 200, 200, 200)
                            .addComponent(txtAgentId, 200, 200, 200)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd).addGap(8)
                        .addComponent(btnUpdate).addGap(8)
                        .addComponent(btnDelete).addGap(8)
                        .addComponent(btnDispatch).addGap(8)
                        .addComponent(btnClear))
                    .addComponent(jScrollPane1, 750, 750, 750))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15).addComponent(jLabel1).addGap(15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(txtOrderId))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(txtClientId))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4).addComponent(txtTotalAmount))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5).addComponent(cmbStatus))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6).addComponent(txtDeliveryAddress))
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7).addComponent(txtAgentId))
                .addGap(15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd).addComponent(btnUpdate).addComponent(btnDelete).addComponent(btnDispatch).addComponent(btnClear))
                .addGap(15)
                .addComponent(jScrollPane1, 200, 200, 200)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Order o = new Order();
            o.setClientId(Integer.parseInt(txtClientId.getText().trim()));
            o.setOrderDate(new Date());
            o.setTotalAmount(Double.parseDouble(txtTotalAmount.getText().trim()));
            o.setStatus(cmbStatus.getSelectedItem().toString());
            o.setDeliveryAddress(txtDeliveryAddress.getText().trim());
            String agentStr = txtAgentId.getText().trim();
            o.setAgentId(agentStr.isEmpty() ? 0 : Integer.parseInt(agentStr));
            if (orderService.addOrder(o)) {
                JOptionPane.showMessageDialog(this, "Order created successfully!");
                clearFields(); loadTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to create order.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtOrderId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select an order from the table first."); return;
        }
        try {
            Order o = orderService.getOrderById(Integer.parseInt(txtOrderId.getText().trim()));
            if (o == null) { JOptionPane.showMessageDialog(this, "Order not found."); return; }
            o.setStatus(cmbStatus.getSelectedItem().toString());
            o.setDeliveryAddress(txtDeliveryAddress.getText().trim());
            String agentStr = txtAgentId.getText().trim();
            if (!agentStr.isEmpty()) o.setAgentId(Integer.parseInt(agentStr));
            if (orderService.updateOrder(o)) {
                JOptionPane.showMessageDialog(this, "Order updated successfully!");
                clearFields(); loadTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update order.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtOrderId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select an order first."); return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Delete this order?");
        if (confirm == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(txtOrderId.getText().trim());
            if (orderService.deleteOrder(id)) {
                JOptionPane.showMessageDialog(this, "Order deleted!");
                clearFields(); loadTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete order.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void btnDispatchActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtOrderId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select an order from the table first."); return;
        }
        int orderId = Integer.parseInt(txtOrderId.getText().trim());
        int confirm = JOptionPane.showConfirmDialog(this,
            "Dispatch Order #" + orderId + "?\nEmail notifications will be sent to the client and delivery agent.");
        if (confirm == JOptionPane.YES_OPTION) {
            if (orderService.dispatchOrder(orderId)) {
                JOptionPane.showMessageDialog(this, "Order dispatched! Email notifications sent to client and delivery agent.");
                clearFields(); loadTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to dispatch order.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDispatch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrders;
    private javax.swing.JTextField txtAgentId;
    private javax.swing.JTextField txtClientId;
    private javax.swing.JTextField txtDeliveryAddress;
    private javax.swing.JTextField txtOrderId;
    private javax.swing.JTextField txtTotalAmount;
    // End of variables declaration//GEN-END:variables
}
