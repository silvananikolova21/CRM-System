package Services;

import java.util.List;

public interface Service {
    void addClient(Client client);
    void updateClientByID(Client client);
    void viewAll();
    void searchByIndustry(String industry);
    void searchById(long id);
    void searchByName(String name);
    void removeClientByID(long id);
    List<Client> getClients ();
}


