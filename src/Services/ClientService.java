package Services;

import DataProcessing.CustomReader;
import DataProcessing.CustomWriter;

import java.util.List;

public class ClientService implements Service {
    private CustomReader reader;
    private CustomWriter writer;
    private List<Client> clients;

    public ClientService(CustomReader reader, CustomWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.clients = reader.read();
    }

    @Override
    public void addClient(Client client) {
        if (!isValidID(client.getId())) {
            clients.add(client);
        } else {
            System.out.println("Client with such ID already exists");
        }
    }

    @Override
    public void updateClientByID(Client client) {
        if (isValidID(client.getId())) {
            for (Client item: clients) {
                if (item.getId() == client.getId()) {
                    int index = clients.indexOf(item);
                    clients.set(index, client);
                    break;
                }
            }
        } else {
            System.out.println("No such ID found");
        }
    }

    @Override
    public void viewAll() {
        for (Client client:clients) {
            if (client.getStatus().equals("active")) {
                System.out.println(client.toString());
            }
        }
    }

    @Override
    public void searchByIndustry(String industry) {
        if (isValidIndustry(industry)) {
            for (Client client: clients) {
                if (client.getIndustry().equals(industry)) {
                    System.out.println(client.toString());
                }
            }
        } else {
            System.out.println("No clients from this industry");
        }
    }

    @Override
    public void searchById(long id) {
        if (isValidID(id)) {
            for (Client client:clients) {
                if (client.getId() == id) {
                    System.out.println(client.toString());
                }
            }
        } else {
            System.out.println("No such client found");
        }
    }

    @Override
    public void searchByName(String name) {
        if (isValidName(name)) {
            for (Client client:clients) {
                if (client.getName().equals(name)) {
                    System.out.println(client.toString());
                }
            }
        } else {
            System.out.println("No client found");
        }
    }

    @Override
    public void removeClientByID(long id) {
        if (isValidID(id)) {
            for (Client client: clients) {
                if (client.getId() == id) {
                    client.setStatus("inactive");
                }
            }
        } else {
            System.out.println("No such client found");
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    // Validations

    public boolean isValidIndustry (String industry) {
        int validCount = 0;
        for (Client client: clients) {
            if (client.getIndustry().equals(industry)) {
                validCount++;
            }
        }
        if (validCount == 0) {
            return false;
        } else {
            return true;
        }
    }
    public boolean isValidID (long id) {
        for (Client client: clients) {
            if (client.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidName (String name) {
        for (Client client: clients) {
            if (client.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
