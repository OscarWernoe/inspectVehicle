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
        System.out.println("The receipt has been printed.");
    }
    
    /**
     * Prints the results of an inspection.
     * 
     * @param result The inspection result as a <code>String</code>.
     */
    public void printInspectionResult(String result) {
        System.out.println("Inspection results:");
        System.out.println(result + "\n");
    }
}
