package se.kth.iv1350.inspectVehicle.view;

import java.util.Scanner;
import se.kth.iv1350.inspectVehicle.controller.Controller;
import se.kth.iv1350.inspectVehicle.controller.RegistrationFailedException;

/**
 * This class is a placeholder for the view.
 */
public class View {
    private final Controller contr;
    private final ErrorMessageHandler errorMsgHandler;
    private final LogHandler logger;
    private final InspectionStatsView inspectionStats = new InspectionStatsView();
    
    /**
     * Creates a new instance with a controller.
     * 
     * @param contr The controller for the system operations.
     */
    public View(Controller contr, ErrorMessageHandler errorMsgHandler, LogHandler logger) {
        this.contr = contr;
        this.contr.addInspectionObserver(inspectionStats);
        this.errorMsgHandler = errorMsgHandler;
        this.logger = logger;
    }
    
    /**
     * Calls all the system operations in the controller.
     */
    public void sampleExecution() {
        contr.beginInspection();
        System.out.println("Customer has entered the garage.");
        contr.closeGarageDoor();
        Scanner in = new Scanner(System.in);
        String regNo;
        int cost;
        while(true) {
            try {
                System.out.println("Please input vehicle's registration number: ");
                regNo = in.next();
                cost = contr.registerVehicle(regNo);
                in.close();
                break;
            }
        
            catch(RegistrationFailedException regFailedExc) {
                errorMsgHandler.showErrorMsg(regFailedExc.getMessage() + 
                        " Cause: " + regFailedExc.getCause().getMessage());
                logger.logException(regFailedExc);
            }
        }
        System.out.println("The total cost of the inspection is " + cost + ".");
        contr.paymentByCreditCard(cost);
        String request = contr.requestInspectionItem();
        int index = 0;
        while(request != null) {
            request = contr.requestInspectionItem();
            contr.enterInspectionResult("Passed", index++);
        }
        contr.openGarageDoor();
        System.out.println("Customer has left the garage.");
        contr.closeGarageDoor();
        inspectionStats.showInspectionStats();
    }
}
