package se.kth.iv1350.inspectVehicle.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.inspectVehicle.integration.DatabaseManager;
import se.kth.iv1350.inspectVehicle.integration.Printer;

public class InspectionTest {
    private Vehicle vehicle;
    private DatabaseManager dbMgr;
    private Printer printer;
    private Inspection instance;
    
    @Before
    public void setUp() {
        vehicle = new Vehicle("ABC123");
        dbMgr = new DatabaseManager();
        printer = new Printer();
        instance = new Inspection(vehicle, dbMgr, printer);
    }
    
    @After
    public void tearDown() {
        vehicle = null;
        dbMgr = null;
        printer = null;
        instance = null;
    }

    @Test
    public void testGetCost() {
        int expResult = 60;
        int result = instance.getCost();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHasMoreInspectionsWithMoreInspections() {
        boolean expResult = true;
        boolean result = instance.hasMoreInspections();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHasMoreInspectionsWithNoMoreInspections() {
        instance.getNextInspection();
        instance.getNextInspection();
        instance.getNextInspection();
        boolean expResult = false;
        boolean result = instance.hasMoreInspections();
        assertEquals(expResult, result);
    }
}
