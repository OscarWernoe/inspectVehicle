package se.kth.iv1350.inspectVehicle.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InspectionTest {
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetCostWithInspections() {
        int expResult = 60;
        int result = instance.getCost();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetCostWithNoInspections() {
        int expResult = 0;
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
        boolean expResult = false;
        boolean result = instance.hasMoreInspections();
        assertEquals(expResult, result);
    }
}
