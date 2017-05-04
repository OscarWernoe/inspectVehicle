package se.kth.iv1350.inspectVehicle.model;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Controls the garage door.
 */
public class GarageDoor {
    private static final String CLOSED_TEXT = "The door is closed";
    private static final String OPEN_TEXT = "The door is open";
    private static final Color CLOSED_COLOR = Color.RED;
    private static final Color OPEN_COLOR = Color.GREEN;
    
    private final JLabel doorStateLabel = new JLabel("", SwingConstants.CENTER);
    
    /**
     * Connects to the door servo and closes the door.
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    GarageDoor() {
        close();
        contactDoor();
    }
    
    /**
     * Opens the garage door.
     */
    void open() {
        doorStateLabel.setForeground(OPEN_COLOR);
        doorStateLabel.setText(OPEN_TEXT);
    }
    
    /**
     * Closes the garage door.
     */
    void close() {
        doorStateLabel.setForeground(CLOSED_COLOR);
        doorStateLabel.setText(CLOSED_TEXT);
    }
    
    private void contactDoor() {
        JFrame frame = new JFrame("Physical Garage Door");
        Font labelFont = new Font(Font.SERIF, Font.BOLD, 30);
        doorStateLabel.setFont(labelFont);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.getContentPane().add(doorStateLabel);
        frame.setBounds(200, 0, 350, 50);
        frame.setVisible(true);
    }
}
