package se.kth.iv1350.inspectVehicle.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.inspectVehicle.model.Vehicle;

/**
 * This class is responsible for database calls. This is the only place the database is called.
 */
public class DatabaseManager {
    private List<InspectionItem> inspectionList;

    /**
     * Creates a new instance, which uses a hard coded list of inspections instead of calling a
     * database.
     */
    public DatabaseManager() {
        createInspectionList();
    }

    /**
     * Searches the database for inspections to be performed on the specified vehicle. This dummy
     * implementation returns hard coded inspections for some vehicles.
     *
     * @param vehicle The vehicle to inspect.
     * @return A list of <code>InspectionItem</code>, where each element describes one particular
     *         control.
     */
    public List<InspectionItem> findInspectionsByVehicle(Vehicle vehicle) {
        if (vehicle.getRegNo().equals("ABC123")) {
            return inspectionList;
        }
        return null;
    }

    /**
     * Creates a hard coded inspection list.
     */
    private void createInspectionList() {
        inspectionList = new ArrayList<>();
        inspectionList.add(new InspectionItem("Brakes", 10, "Failed"));
        inspectionList.add(new InspectionItem("Suspension", 20, "Failed"));
        inspectionList.add(new InspectionItem("Engine", 30, "Failed"));
    }

    /**
     * Stores the result of an inspection in the <code>inspectionList</code>.
     * 
     * @param result The result of the inspection.
     * @param inspectionIndex 
     */
    public void storeInspectionResult(String result, int inspectionIndex) {
        inspectionList.get(inspectionIndex).updateResult(result);
    }
}