package se.kth.iv1350.inspectVehicle.model;

import java.util.List;
import java.util.Iterator;
import se.kth.iv1350.inspectVehicle.integration.DatabaseManager;
import se.kth.iv1350.inspectVehicle.integration.DatabaseManagerException;
import se.kth.iv1350.inspectVehicle.integration.InspectionItem;
import se.kth.iv1350.inspectVehicle.integration.Printer;

/**
 * Represents an inspection of a vehicle.
 */
public class Inspection {
    private final Vehicle vehicle;
    private final DatabaseManager dbMgr;
    private final Printer printer;
    private final List<InspectionItem> inspections;
    private final Iterator<InspectionItem> inspectionsIterator;
    public InspectionResult result;
    
     /**
     * Creates a new instance, representing an inspection of the specified vehicle.
     *
     * @param vehicle The vehicle that is inspected.
     * @param dbMgr   The database manager to use when searching for inspections for the specified
     *                vehicle.
     * @throws DatabaseManagerException if the database call failed.
     */
    public Inspection(Vehicle vehicle, DatabaseManager dbMgr, Printer printer) {
        this.vehicle = vehicle;
        this.dbMgr = dbMgr;
        this.printer = printer;
        this.inspections = dbMgr.findInspectionsByVehicle(this.vehicle);
        this.inspectionsIterator = inspections.iterator();
        this.result = new InspectionResult(this.dbMgr, this.printer, this.inspections);
    }
    
     /**
     * @return The cost of this inspection.
     */
    public int getCost() {
        int totalCost = 0;
        if (inspections == null) {
            return 0;
        }
        for (InspectionItem inspItem : inspections) {
            totalCost = totalCost + inspItem.getCost();
        }
        return totalCost;
    }
    
    /**
     * Checks if there are more inspections to be done.
     * 
     * @return <code>true</code> if there are more inspections, <code>false</code> if there 
     * are no more inspections.
     */
    public boolean hasMoreInspections() {
        return inspectionsIterator.hasNext();
    }
    
    /**
     * Gets the next item to inspect on the vehicle by iterating through
     * the list of inspections.
     * 
     * @return The name of the next <code>InspectionItem</code> in the list of inspections.
     */
    public String getNextInspection() {
        return inspectionsIterator.next().getName();
    }
}
