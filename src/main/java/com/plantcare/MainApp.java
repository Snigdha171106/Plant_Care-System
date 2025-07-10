package com.plantcare;

import java.util.Scanner;
import com.plantcare.ReminderThread;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlantService plantService = new PlantService();
        ReminderThread reminder = new ReminderThread();
        reminder.start();

        while (true) {
            System.out.println("===== Plant Care Information System =====");
            System.out.println("1. Add New Plant");
            System.out.println("2. View Plant Care Info");
            System.out.println("3. Show All Plants");
            System.out.println("4. Exit");
            System.out.print("Select option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                plantService.addPlant();
            } else if (choice == 2) {
                plantService.showPlantCareInfo();
            } else if (choice == 3) {
                plantService.listAllPlants();
            } else if (choice == 4) {
                reminder.interrupt();
                System.out.println("Exiting program!!");
                break;
            } else {
                System.out.println("Invalid choice. Try again.\n");
            }
        }

        scanner.close();
    }
}