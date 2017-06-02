package se.kth.iv1350.inspectVehicle.view;

/**
 * Shows the total number of passed and failed inspections.
 */
public class InspectionStatsView implements InspectionObserver {
    private int passedInspections;
    private int failedInspections;
    
    /**
     * Creates a new instance with the counters set to zero.
     */
    InspectionStatsView() {
        this.passedInspections = 0;
        this.failedInspections = 0;
    }
    
    @Override
    public void newInspectionResult(boolean passedInspection) {
        if(passedInspection) {
            passedInspections++;
        }
        else {
            failedInspections++;
        }
    }
    
    /**
     * Prints out the current number of passed and failed inspections.
     */
    void showInspectionStats() {
        System.out.println("---");
        System.out.println("Number of passed inspections: " + passedInspections);
        System.out.println("Number of failed inspections: " + failedInspections);
        System.out.println("---");
    }
}
