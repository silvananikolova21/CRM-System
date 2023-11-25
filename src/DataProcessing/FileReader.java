package DataProcessing;

import Services.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements CustomReader {
    @Override
    public List<Client> read() {
        List<Client> clients = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader("src/DataProcessing/data.csv"))){
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] clientsArr = line.split(",");
                Client client = new Client(Long.parseLong(clientsArr[0]), clientsArr[1], clientsArr[2], clientsArr[3], Double.parseDouble(clientsArr[4]));
                clients.add(client);
            }
        }catch (IOException e){
            System.out.println("No such file found");
        }
        return clients;
    }
}
