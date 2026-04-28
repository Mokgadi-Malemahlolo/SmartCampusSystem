package hostel;

/*
 * The RoomAllocation class  models a single hostel room
 * Each room has a number, type, and tracks who is staying in it
 */

public class RoomAllocation {

    // VARIABLES IN EACH ROOM
    int roomNumber;
    String roomType; // Single or Sharring
    boolean isOccupied;
    String occupantName;
    String occupantID;

   // This runs everytime we create a new room object
    public RoomAllocation(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isOccupied = false;
        this.occupantName = "";
        this.occupantID = "";
    }

    public void display() {
        if (isOccupied) {
            //if occuied,it shows who is living there
            System.out.println("Room " + roomNumber + " [" + roomType + "] - OCCUPIED by "
                    + occupantName + " (ID: " + occupantID + ")");
        } else {
            //If room is empty, it shows it as available
            System.out.println("Room " + roomNumber + " [" + roomType + "] - AVAILABLE");
        }
    }
}