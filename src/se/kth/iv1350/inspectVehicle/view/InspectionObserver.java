package se.kth.iv1350.inspectVehicle.view;

/**
 * A listener interface for receiving notifications about inspections.
 */
public interface InspectionObserver {
    /**
     * Invoked when a new inspection result is entered.
     */
    public void newInspectionResult(boolean passedInspection);
}
