package se.kth.iv1350.inspectVehicle.model;

import java.util.List;
import se.kth.iv1350.inspectVehicle.integration.DatabaseManager;
import se.kth.iv1350.inspectVehicle.integration.InspectionItem;
import se.kth.iv1350.inspectVehicle.integration.Printer;

/**
 * Represents the results of an inspection.
 */
public class InspectionResult {
    private final DatabaseManager dbMgr;
    private final Printer printer;
    private final List<InspectionItem> inspectionList;
    
    /**
     * Creates a new instance using the list of inspections to be performed.
     * 
     * @param dbMgr The <code>DatabaseManager</code> that handles calls to the database.
     * @param printer The <code>Printer</code> used for printing.
     * @param inspectionList The list of inspections to be performed.
     */
    public InspectionResult(DatabaseManager dbMgr, Printer printer, List<InspectionItem> inspectionList) {
        this.dbMgr = dbMgr;
        this.printer = printer;
        this.inspectionList = inspectionList;
    }
    
    /**
     * Uses the <code>DatabaseManager</code> to store the entered result and 
     * the <code>Printer</code> to print the results.
     * 
     * @param result The result of the inspection.
     * @param inspectionIndex The index of the inspection in <code>inspectionList</code>.
     */
    public void enterResult(String result, int inspectionIndex) {
        dbMgr.storeInspectionResult(result, inspectionIndex);
        int maxInspectionIndex = this.inspectionList.size() - 1;
        if(inspectionIndex == maxInspectionIndex) {
            printer.printInspectionResults(this.toString());
        }
        
    }
    
    /**
     * Converts the inspection result to a <code>String</code>.
     * 
     * @return The result as a <code>String</code>.
     */
    @Override
    public String toString() {
        StringBuilder printout = new StringBuilder();
        this.inspectionList.forEach((inspItem) -> {
            printout.append("\n").append(inspItem.getName()).append("\t").append(inspItem.getResult());
        });
        return printout.toString();
    }
}
