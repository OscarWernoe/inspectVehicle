package se.kth.iv1350.inspectVehicle.integration;

/**
 * Represents a printer.
 */
public class Printer {
    
    /**
     * Creates a new instance.
     */
    public Printer() {};
    
    /**
     * Prints the receipt for an inspection.
     * 
     * @param cost The cost of the inspection.
     */
    public void printReceipt(int cost) {
        System.out.println("Printing receipt...");
    }
    
    /**
     * Prints the results of an inspection.
     * 
     * @param results The inspection results as a <code>String</code>.
     */
    public void printInspectionResults(String results) {
        System.out.println("Printing inspection results...");
        System.out.println(results);
    }
}
