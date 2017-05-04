package se.kth.iv1350.inspectVehicle.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.inspectVehicle.integration.*;
import se.kth.iv1350.inspectVehicle.model.*;

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
    public void testRegisterVehicleWithInspections() {
        String regNo = "ABC123";
        int expResult = 60;
        int result = instance.registerVehicle(regNo);
        assertEquals("Wrong cost with inspections.", expResult, result);
    }

    @Test
    // Will need to fix bug related to inspectionsIterator.
    public void testRegisterVehicleWithNoInspections() {
        String regNo = "CBA321";
        int expResult = 0;
        int result = instance.registerVehicle(regNo);
        assertEquals("Wrong cost with no inspections.", expResult, result);
    }

    @Test
    public void testRequestInspectionItemWithMoreInspections() {
        instance.registerVehicle("ABC123");
        String expResult = "Brakes";
        String result = instance.requestInspectionItem();
        assertEquals("Wrong inspection item returned with more inspections", expResult, result);
    }

    @Test
    public void testRequestInspectionItemWithNoMoreInspections() {
        instance.registerVehicle("ABC123");
        instance.requestInspectionItem();
        instance.requestInspectionItem();
        instance.requestInspectionItem();
        String expResult = null;
        String result = instance.requestInspectionItem();
        assertEquals("Wrong inspection item returned with no more inspections", expResult, result);
    }
}
