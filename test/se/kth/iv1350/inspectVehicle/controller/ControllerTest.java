package se.kth.iv1350.inspectVehicle.controller;

import se.kth.iv1350.inspectVehicle.integration.CreditCardReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.inspectVehicle.integration.DatabaseManager;
import se.kth.iv1350.inspectVehicle.integration.Printer;
import se.kth.iv1350.inspectVehicle.model.Garage;


public class ControllerTest {
    private Garage garage;
    private DatabaseManager dbMgr;
    private CreditCardReader cardReader;
    private Printer printer;
    private Controller instance;
    
    @Before
    public void setUp() {
        garage = new Garage();
        dbMgr = new DatabaseManager();
        cardReader = new CreditCardReader();
        printer = new Printer();
        instance = new Controller(garage, dbMgr, cardReader, printer);
    }
    
    @After
    public void tearDown() {
        garage = null;
        dbMgr = null;
        cardReader = null;
        printer = null;
        instance = null;
    }
    
    @Test
    public void testRegisterVehicleWhenVehicleExists() {
        String regNo = "ABC123";
        try {
            instance.registerVehicle(regNo);
        }
        catch (RegistrationFailedException exc) {
            fail("Exception was thrown: " + exc.getMessage());
        }
    }

    @Test(expected = RegistrationFailedException.class)
    public void testRegisterVehicleWhenVehicleDoesNotExist() throws
            RegistrationFailedException {
        String regNo = "CBA321";
        instance.registerVehicle(regNo);
    }

    @Test
    public void testRequestInspectionItemWithMoreInspections() throws
            RegistrationFailedException {
        instance.registerVehicle("ABC123");
        String result = instance.requestInspectionItem();
        assertNotNull("Wrong inspection item returned with more inspections", result);
    }

    @Test
    public void testRequestInspectionItemWithNoMoreInspections() throws
            RegistrationFailedException {
        instance.registerVehicle("ABC123");
        instance.requestInspectionItem();
        instance.requestInspectionItem();
        instance.requestInspectionItem();
        String result = instance.requestInspectionItem();
        assertNull("Wrong inspection item returned with no more inspections", result);
    }
}
