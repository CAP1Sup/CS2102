package edu.wpi.hw5;

/**
 * This exception is thrown when a candidate is voted for more than once in a
 * single vote
 */
public class MoreThanOnceException extends Exception {

    /**
     * Creates a new MoreThanOnceException
     *
     * @param candidateName The name of the candidate that voted for more than once
     */
    public MoreThanOnceException(String candidateName) {
        super(String.format("%s was voted for more than once in a single vote", candidateName));
    }
}
