package se.kth.iv1350.inspectVehicle.integration;

/**
 * Represents an particular control of a vehicle, for example brakes or suspension.
 */
public class InspectionItem {
    private final String name;
    private final int cost;
    private String result;

    /**
     * Creates new instance representing the specified control.
     *
     * @param name The name of this control.
     * @param cost The cost of this control.
     * @param result The result of this control.
     */
    InspectionItem(String name, int cost, String result) {
        this.name = name;
        this.cost = cost;
        this.result = result;
    }

    /**
     * @return The cost of this control.
     */
    public int getCost() {
        return cost;
    }
    
    /**
     * @return The name of this control.
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return The result of this control.
     */
    public String getResult() {
        return result;
    }
    
    /**
     * Updates the result of this control.
     * 
     * @param result The result of the control.
     */
    public void setResult(String result) {
        this.result = result;
    }
    
    /**
     * @return True if the specified object is considered to represent the same inspection item as
     *         this object.
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof InspectionItem)) {
            return false;
        }
        InspectionItem otherInspItem = (InspectionItem) other;
        return otherInspItem.cost == this.cost && otherInspItem.name.equals(this.name);
    }
}
