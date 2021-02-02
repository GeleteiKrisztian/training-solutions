package week12d04;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Clients {

    private Map<String, Client> clients;

    public Clients(Map<String, Client> clients) {
        this.clients = clients;
    }

    public Client findByRegNumber(String regNum) {
        return clients.get(regNum);
    }

    public List<Client> findByName(String name) {
        List<Client> clientsResult = new ArrayList<>();
        for (Client item : clients.values()) {
            if (item.getName().contains(name)) {
                clientsResult.add(item);
            }
        }
        if (clientsResult.size() > 0) {
            return clientsResult;
        } else {
            throw new IllegalArgumentException("");
        }
    }

}