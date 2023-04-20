package edu.wpi.hw5;

/**
 * This exception is thrown when a candidate is nominated twice.
 */
public class AlreadyNominatedException extends Exception {

    /**
     * Creates a new AlreadyNominatedException
     *
     * @param candidateName The name of the candidate that was already nominated
     */
    public AlreadyNominatedException(String candidateName) {
        super(String.format("%s was already nominated", candidateName));
    }
}
