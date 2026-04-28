package events; // this file belongs to the events package

import java.util.ArrayList;
import java.util.Scanner;

/*
 * EventManager class - manages all event bookings in the system
 * This is where all the logic happens - booking, viewing and removing events
 * We use an ArrayList here because events are frequently added and removed
 * ArrayList is perfect for frequent insertion and deletion operations
 */
public class EventManager {

    // --- INSTANCE VARIABLES ---

    // ArrayList that stores all booked events
    // Unlike arrays, ArrayList can grow and shrink automatically
    private ArrayList<Event> eventList;
    Scanner scanner = new Scanner(System.in);

    /*
     * CONSTRUCTOR - sets up the event manager when the system starts
     * Creates an empty ArrayList ready to store events
     */
    public EventManager() {
        eventList = new ArrayList<>(); // start with an empty list of events
    }

    /*
     * bookEvent() - allows a user to book a new event
     * Asks for event name, date and venue then adds it to the list
     */
    public void bookEvent() {
        System.out.print("Enter event name: ");
        String name = scanner.nextLine();

        System.out.print("Enter event date (e.g. 2026-05-01): ");
        String date = scanner.nextLine();

        System.out.print("Enter event venue: ");
        String venue = scanner.nextLine();

        // create a new Event object and add it to the ArrayList
        eventList.add(new Event(name, date, venue));
        System.out.println("Event booked successfully!");
    }

    /*
     * viewEvents() - displays all currently booked events
     * If no events are booked it tells the user the list is empty
     */
    public void viewEvents() {
        // check if there are any booked events
        if (eventList.isEmpty()) {
            System.out.println("No events have been booked yet.");
            return;
        }

        System.out.println("\n--- Booked Events ---");
        // loop through the ArrayList and display each event
        for (int i = 0; i < eventList.size(); i++) {
            System.out.print((i + 1) + ". ");
            eventList.get(i).display(); // call display() on each Event object
        }
    }

    /*
     * removeEvent() - removes an event from the list by name
     * Searches through the ArrayList for a matching event name
     * If found it removes it, if not found it tells the user
     */
    public void removeEvent() {
        // first check if there are any events to remove
        if (eventList.isEmpty()) {
            System.out.println("No events to remove.");
            return;
        }

        System.out.print("Enter event name to remove: ");
        String name = scanner.nextLine();

        // loop through the list to find the matching event
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).eventName.equalsIgnoreCase(name)) {
                eventList.remove(i); // remove the event at position i
                System.out.println("Event removed successfully!");
                return; // stop searching once found
            }
        }
        // if we get here the event was not found
        System.out.println("Event not found: " + name);
    }

    /*
     * showMenu() - displays the event booking menu
     * Keeps running until the user chooses to go back to the main menu
     */
    public void showMenu() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("\n=== Event Booking System ===");
            System.out.println("1. Book an event");
            System.out.println("2. View all booked events");
            System.out.println("3. Remove an event");
            System.out.println("0. Back to main menu");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: bookEvent(); break;
                case 2: viewEvents(); break;
                case 3: removeEvent(); break;
                case 0: System.out.println("Returning to main menu..."); break;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}