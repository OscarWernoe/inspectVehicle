package se.kth.iv1350.inspectVehicle.model;

/**
 * Represents a vehicle to be inspected.
 */
public class Vehicle {
    private final String regNo;
    
    /**
     * Creates a new instance.
     * 
     * @param regNo The registration number of the vehicle.
     */
    public Vehicle(String regNo) {
        this.regNo = regNo;
    }
    
    /**
     * @return The registration number of the vehicle.
     */
    public String getRegNo() {
        return regNo;
    }
}
