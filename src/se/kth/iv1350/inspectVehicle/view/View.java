package se.kth.iv1350.inspectVehicle.view;

import se.kth.iv1350.inspectVehicle.controller.Controller;

/**
 * This class is a placeholder for the view.
 */
public class View {
    private final Controller contr;
    
    /**
     * Creates a new instance with a controller.
     * 
     * @param contr The controller for the system operations.
     */
    public View(Controller contr) {
        this.contr = contr;
    }
    
    /**
     * Calls all the system operations in the controller.
     */
    public void sampleExecution() {
        contr.beginInspection();
        int cost = contr.registerVehicle("ABC123");
        contr.paymentByCreditCard(cost);
        
        String request = contr.requestInspectionItem();
        int index = 0;
        while(request != null) {
            request = contr.requestInspectionItem();
            contr.enterInspectionResult("Passed", index++);
        }
        
        contr.openGarageDoor();
        contr.closeGarageDoor();
    }
}
