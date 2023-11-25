package Main;

import Services.ClientManager;
import Services.ClientService;
import Services.Manager;
import Services.Service;
import DataProcessing.CustomReader;
import DataProcessing.CustomWriter;
import DataProcessing.FileReader;
import DataProcessing.FileWriter;

import java.util.Scanner;

public class ClientManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomReader reader = new FileReader();
        CustomWriter writer = new FileWriter();

        Service service = new ClientService(reader, writer);
        Manager manager = new ClientManager(service);
        System.out.println("Welcome to the Client Management System");
        displayOptions();
        String command = sc.nextLine();
        boolean active = true;
        while (active) {
            manager.performAction(command);

// Add Services.Client
// 1, Oceanic Enterprises, Finance, Sarah Smith, 500000.00
// Update Services.Client
// 1, Oceanic Enterprises, Tech, Sarah Smith, 750000.00
// View Clients
// Search Industry Tech
// Search ID 1
// Remove Services.Client 1
// Search Name Oceanic
// Save &amp; Exit
            if (command.equals("8")) {
                active = false;
            } else {
                System.out.println("Choose the corresponding number from the options above:");
                command = sc.nextLine();
            }
        }
    }
    public static void displayOptions () {
        System.out.println("Choose the corresponding number from the options below:");
        System.out.println("1 Add client");
        System.out.println("2 Update client by ID");
        System.out.println("3 View clients");
        System.out.println("4 Search by industry");
        System.out.println("5 Search by ID");
        System.out.println("6 Search by name");
        System.out.println("7 Remove client by ID");
        System.out.println("8 Save and Exit");

    }
}
