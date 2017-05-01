package model;

/**
 * This is a facade to the hardware of the garage, namely the door and the queue
 * number display on the outside wall.
 */
public class Garage {
    private final GarageDoor door = new GarageDoor();
    private final Display display = new Display();
    
    /**
     * Creates an instance and connects to the door and queue number display.
     */
    public Garage() {
    }
    
    /**
     * Opens the door and displays the next queue number.
     */
    public void nextCustomer() {
        door.open();
        display.nextNumber();
    }
    
    /**
     * Closes the door.
     */
    public void closeDoor() {
        door.close();
    }
}
