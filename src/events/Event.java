package events; // this file belongs to the events package

/*
 * Event class - represents a single event booking
 * This is the blueprint for every event created in the system
 * Each event has a name, date and venue
 */
public class Event {

    // --- INSTANCE VARIABLES (data that every event holds) ---

    String eventName; // the name of the event e.g. "Freshers Party"
    String eventDate; // the date of the event e.g. "2026-05-01"
    String eventVenue; // the venue of the event e.g. "Main Hall"

    /*
     * CONSTRUCTOR - runs every time we create a new Event object
     * Sets up the event with a name, date and venue
     */
    public Event(String eventName, String eventDate, String eventVenue) {
        this.eventName = eventName;   // set the event name
        this.eventDate = eventDate;   // set the event date
        this.eventVenue = eventVenue; // set the event venue
    }

    /*
     * display() - prints the details of this event in a clean format
     */
    public void display() {
        System.out.println("Event: " + eventName +
                " | Date: " + eventDate +
                " | Venue: " + eventVenue);
    }
}