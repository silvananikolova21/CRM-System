package Services;

import DataProcessing.FileWriter;

import java.util.Scanner;

public class ClientManager implements Manager {
    private Service service;

    public ClientManager(Service service) {
        this.service = service;
    }

    @Override
    public void performAction(String command) {
        Scanner sc = new Scanner(System.in);
        if (command.equals("1")) {
            System.out.println("Enter client");
            String clientToAdd = sc.nextLine();
            String[] clientToAddArr = clientToAdd.split(", ");
            Client client = new Client(Long.parseLong(clientToAddArr[0]), clientToAddArr[1], clientToAddArr[2], clientToAddArr[3], Double.parseDouble(clientToAddArr[4]));
            service.addClient(client);

        } else if (command.equals("2")) {
            System.out.println("Enter clients new data");
            String newData = sc.nextLine();
            String[] newDataArr = newData.split(", ");
            Client client = new Client(Long.parseLong(newDataArr[0]), newDataArr[1], newDataArr[2], newDataArr[3], Double.parseDouble(newDataArr[4]));

            service.updateClientByID(client);

        } else if (command.equals("3")) {
            service.viewAll();

        } else if (command.equals("4")) {
            System.out.println("Enter industry");
            String industry = sc.nextLine();
            service.searchByIndustry(industry);

        } else if (command.equals("5")) {
            System.out.println("Enter ID number");
            long id = Long.parseLong(sc.nextLine());
            service.searchById(id);

        } else if (command.equals("6")) {
            System.out.println("Enter name");
            String name = sc.nextLine();
            service.searchByName(name);

        } else if (command.equals("7")) {
            System.out.println("Enter client ID to remove");
            long id = Long.parseLong(sc.nextLine());
            service.removeClientByID(id);


        } else if (command.equals("8")) {
            FileWriter fw = new FileWriter();
            fw.write(service.getClients());
        }
    }
}