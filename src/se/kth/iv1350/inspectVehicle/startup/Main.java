package se.kth.iv1350.inspectVehicle.startup;

import java.io.IOException;
import se.kth.iv1350.inspectVehicle.controller.Controller;
import se.kth.iv1350.inspectVehicle.integration.CreditCardReader;
import se.kth.iv1350.inspectVehicle.integration.DatabaseManager;
import se.kth.iv1350.inspectVehicle.integration.Printer;
import se.kth.iv1350.inspectVehicle.model.Garage;
import se.kth.iv1350.inspectVehicle.view.ErrorMessageHandler;
import se.kth.iv1350.inspectVehicle.view.LogHandler;
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
    public static void main(String[] args) throws IOException {
        Garage garage = new Garage();
        DatabaseManager dbMgr = new DatabaseManager();
        CreditCardReader creditCardReader = new CreditCardReader();
        Printer printer = new Printer();
        Controller contr = new Controller(garage, dbMgr, creditCardReader, printer);
        ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();
        LogHandler logger = new LogHandler();
        View view = new View(contr, errorMsgHandler, logger);
        view.sampleExecution();
    }
}
