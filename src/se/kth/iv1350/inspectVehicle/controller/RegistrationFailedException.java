package se.kth.iv1350.inspectVehicle.controller;

/**
 * Thrown when the registration of a vehicle fails.
 */
public class RegistrationFailedException extends Exception {

    /**
     * Creates a new instance with a message describing what went wrong.
     * 
     * @param msg A message that describes what went wrong.
     * @param cause The cause of the exception.
     */
    public RegistrationFailedException(String msg, Exception cause) {
        super(msg, cause);
    }
}
