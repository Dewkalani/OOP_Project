package services;

import dao.ClientDB;
import models.Client;
import java.util.List;

public class ClientService {

    private final ClientDB dao = new ClientDB();

    public boolean addClient(Client c) {
        return dao.addClient(c);
    }

    public boolean updateClient(Client c) {
        return dao.updateClient(c);
    }

    public boolean deleteClient(int clientId) {
        return dao.deleteClient(clientId);
    }

    public List<Client> getAllClients() {
        return dao.getAllClients();
    }

    public Client getClientById(int clientId) {
        return dao.getClientById(clientId);
    }
}
