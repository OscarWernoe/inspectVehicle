package se.kth.iv1350.inspectVehicle.controller;

import se.kth.iv1350.inspectVehicle.model.*;
import se.kth.iv1350.inspectVehicle.integration.*;

/**
 * This is the application's single controller. All calls to the model pass through here.
 */
public class Controller {
    private final Garage garage;
    private final DatabaseManager dbMgr;
    private final CreditCardReader cardReader;
    private final Printer printer;
    private Inspection inspection;
    
    /**
     * Creates a new instance using the specified objects.
     * 
     * @param garage The garage where the inspection is taking place.
     * @param dbMgr The database manager that handles calls to the database.
     * @param cardReader The credit card reader which handles all transactions.
     * @param printer The printer used for printing the receipt and inspection results.
     */
    public Controller(Garage garage, DatabaseManager dbMgr, CreditCardReader cardReader, Printer printer) {
        this.garage = garage;
        this.dbMgr = dbMgr;
        this.cardReader = cardReader;
        this.printer = printer;
    }
    
    /**
     * Tells the program to begin a new inspection. Calls method in the <code>Garage</code> class.
     */
    public void beginInspection() {
        garage.nextCustomer();
    }
    
    /**
     * Tells the program to close the garage door. Calls method in the <code>Garage</code> class.
     */
    public void closeGarageDoor() {
        garage.closeDoor();
    }
    
    /**
     * Tells the program to open the garage door. Calls method in the <code>Garage</code> class.
     */
    public void openGarageDoor() {
        garage.openDoor();
    }
    
    /**
     * Registers the customer's vehicle and gets the cost of the inspection.
     * 
     * @param regNo The registration number of the vehicle to inspect.
     * @return The cost of the inspection.
     */
    public int registerVehicle(String regNo) {
        Vehicle vehicle = new Vehicle(regNo);
        this.inspection = new Inspection(vehicle, dbMgr, printer);
        return inspection.getCost();
    }
    
    /**
     * Tells the program to make a payment by credit card. 
     * Gets the customer's credit card from the credit card reader.
     * 
     * @param cost The cost to be paid.
     */
    public void paymentByCreditCard(int cost) {
        CreditCard card = cardReader.getCreditCard();
        boolean authorization = cardReader.makePayment(card, cost);
        if(authorization){
            printer.printReceipt(cost);
        }
    }
    
    /**
     * Requests the next inspection item. Calls methods in the <code>Inspection</code> class.
     * 
     * @return The next inspection item, or, <code>null</code> if there are no more inspections.
     */
    public String requestInspectionItem() {
        if(inspection.hasMoreInspections()) {
            return inspection.getNextInspection();
        }
        else {
            return null;
        }
    }
    
    /**
     * Tells to program to enter the result of an inspection item.
     * 
     * @param result The result of the inspection.
     * @param inspectionIndex The index of the inspection in <code>inspectionList</code>.
     */
    public void enterInspectionResult(String result, int inspectionIndex) {
        this.inspection.results.enterResult(result, inspectionIndex);
    }
}
