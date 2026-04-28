package main;

import hostel.HostelManager;
import events.EventManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HostelManager hostelManager = new HostelManager(10);
        EventManager eventManager = new EventManager();

        int choice = -1;
        while (choice != 0) {
            //MENU OPTIONS
            System.out.println("\n=== Smart Campus Management System ===");
            System.out.println("1. Hostel Allocation");
            System.out.println("2. Event Booking");
            System.out.println("3. Course Registration");
            System.out.println("4. Library Resources");
            System.out.println("5. Help Desk");
            System.out.println("6. Student Records");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: hostelManager.showMenu(); break;
                case 2: eventManager.showMenu(); break;
                case 3: System.out.println("Course Registration - Coming Soon!"); break;
                case 4: System.out.println("Library Resources - Coming Soon!"); break;
                case 5: System.out.println("Help Desk - Coming Soon!"); break;
                case 6: System.out.println("Student Records - Coming Soon!"); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}