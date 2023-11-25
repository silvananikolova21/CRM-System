package DataProcessing;

import Services.Client;

import java.util.List;

public interface CustomWriter {
    void write(List<Client> clients);
}
