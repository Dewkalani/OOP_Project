package services;

import dao.OrderDB;
import dao.ClientDB;
import dao.DeliveryAgentDB;
import models.Order;
import models.Client;
import models.DeliveryAgent;
import java.util.List;

public class OrderService {

    private final OrderDB dao = new OrderDB();
    private final ClientDB clientDB = new ClientDB();
    private final DeliveryAgentDB agentDB = new DeliveryAgentDB();

    public boolean addOrder(Order o) {
        return dao.addOrder(o);
    }

    public boolean updateOrder(Order o) {
        return dao.updateOrder(o);
    }

    public boolean deleteOrder(int orderId) {
        return dao.deleteOrder(orderId);
    }

    /**
     * Dispatches the order and sends email notifications to the client and delivery agent.
     */
    public boolean dispatchOrder(int orderId) {
        Order o = dao.getOrderById(orderId);
        if (o == null) return false;

        Client client = clientDB.getClientById(o.getClientId());
        DeliveryAgent agent = (o.getAgentId() > 0) ? agentDB.getAgentById(o.getAgentId()) : null;

        String clientEmail = (client != null) ? client.getEmail() : "";
        String clientName = (client != null) ? client.getName() : "Client";
        String agentEmail = (agent != null) ? agent.getEmail() : "";
        String agentName = (agent != null) ? agent.getName() : "Agent";

        return dao.dispatchOrder(orderId, clientEmail, clientName, agentEmail, agentName);
    }

    public List<Order> getAllOrders() {
        return dao.getAllOrders();
    }

    public Order getOrderById(int orderId) {
        return dao.getOrderById(orderId);
    }
}
