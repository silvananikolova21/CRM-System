package DataProcessing;

import Services.Client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class FileWriter implements CustomWriter {

    @Override
    public void write(List<Client> clients) {
        try(BufferedWriter bw = new BufferedWriter(new java.io.FileWriter("src/dataProcessing/data.csv"))) {
            bw.write("ID, Name, Industry, ContactPerson, Revenue");
            bw.newLine();
            for (Client client : clients){
                bw.write(client.toString());
                bw.newLine();
            }

        }catch (IOException e){
            System.out.println("No such file");
        }
    }
}
