package se.kth.iv1350.inspectVehicle.integration;

/**
 * Thrown when something goes wrong while performing an operation in
 * the <code>DatabaseManager</code>. The message might contain more information
 * about the error condition.
 */
public class DatabaseManagerException extends RuntimeException {

    /**
     * Creates a new instance representing the condition described in
     * the specified message.
     * 
     * @param msg A message that describes what went wrong.
     */
    public DatabaseManagerException(String msg) {
        super(msg);
    }
}
