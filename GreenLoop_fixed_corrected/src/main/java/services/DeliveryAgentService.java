package services;

import dao.DeliveryAgentDB;
import models.DeliveryAgent;
import java.util.List;

public class DeliveryAgentService {

    private final DeliveryAgentDB dao = new DeliveryAgentDB();

    public boolean addAgent(DeliveryAgent a) {
        return dao.addAgent(a);
    }

    public boolean updateAgent(DeliveryAgent a) {
        return dao.updateAgent(a);
    }

    public boolean deleteAgent(int agentId) {
        return dao.deleteAgent(agentId);
    }

    public List<DeliveryAgent> getAllAgents() {
        return dao.getAllAgents();
    }

    public DeliveryAgent getAgentById(int agentId) {
        return dao.getAgentById(agentId);
    }
}
