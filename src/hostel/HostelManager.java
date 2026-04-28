package hostel;

import java.util.Scanner;

public class HostelManager {
    private RoomAllocation[] rooms;
    private HostelQueue waitingList;
    private int totalRooms;
    Scanner scanner = new Scanner(System.in);

    public HostelManager(int totalRooms) {
        this.totalRooms = totalRooms;
        rooms = new RoomAllocation[totalRooms];
        waitingList = new HostelQueue(50);
        initializeRooms();
    }

    private void initializeRooms() {
        for (int i = 0; i < totalRooms; i++) {
            if (i < totalRooms / 3) {
                rooms[i] = new RoomAllocation(i + 1, "Single");
            } else if (i < (2 * totalRooms) / 3) {
                rooms[i] = new RoomAllocation(i + 1, "Double");
            } else {
                rooms[i] = new RoomAllocation(i + 1, "Triple");
            }
        }
    }

    public void addToWaitingList() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        waitingList.enqueue(name, id);
    }

    public void assignRoom() {
        if (waitingList.isEmpty()) {
            System.out.println("No students in waiting list!");
            return;
        }

        // find available room
        for (int i = 0; i < totalRooms; i++) {
            if (!rooms[i].isOccupied) {
                String[] student = waitingList.dequeue();
                rooms[i].isOccupied = true;
                rooms[i].occupantName = student[0];
                rooms[i].occupantID = student[1];
                System.out.println("Room " + rooms[i].roomNumber +
                        " assigned to " + student[0]);
                return;
            }
        }
        System.out.println("No available rooms right now!");
    }

    public void checkOut() {
        System.out.print("Enter student ID to check out: ");
        String id = scanner.nextLine();

        for (int i = 0; i < totalRooms; i++) {
            if (rooms[i].isOccupied && rooms[i].occupantID.equals(id)) {
                System.out.println(rooms[i].occupantName +
                        " checked out of Room " + rooms[i].roomNumber);
                rooms[i].isOccupied = false;
                rooms[i].occupantName = "";
                rooms[i].occupantID = "";
                return;
            }
        }
        System.out.println("Student ID not found in any room!");
    }

    public void displayAllRooms() {
        System.out.println("\n--- All Rooms ---");
        for (int i = 0; i < totalRooms; i++) {
            rooms[i].display();
        }
    }

    public void displayWaitingList() {
        waitingList.displayQueue();
    }

    public void showMenu() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("\n=== Hostel Allocation System ===");
            System.out.println("1. Add student to waiting list");
            System.out.println("2. Assign room to next student");
            System.out.println("3. Check out student");
            System.out.println("4. View all rooms");
            System.out.println("5. View waiting list");
            System.out.println("0. Back to main menu");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addToWaitingList(); break;
                case 2: assignRoom(); break;
                case 3: checkOut(); break;
                case 4: displayAllRooms(); break;
                case 5: displayWaitingList(); break;
                case 0: System.out.println("Returning to main menu..."); break;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}