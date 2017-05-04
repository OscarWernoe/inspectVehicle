package se.kth.iv1350.inspectVehicle.startup;

import se.kth.iv1350.inspectVehicle.model.*;
import se.kth.iv1350.inspectVehicle.integration.*;
import se.kth.iv1350.inspectVehicle.controller.Controller;
import se.kth.iv1350.inspectVehicle.view.View;

/**
 * The main class, which starts the program.
 */
public class Main {
    
    /**
     * The main method.
     * 
     * @param args There are no command line parameters.
     */
    public static void main(String[] args) {
        Garage garage = new Garage();
        DatabaseManager dbMgr = new DatabaseManager();
        CreditCardReader creditCardReader = new CreditCardReader();
        Printer printer = new Printer();
        Controller contr = new Controller(garage, dbMgr, creditCardReader, printer);
        View view = new View(contr);
        view.sampleExecution();
    }
}
