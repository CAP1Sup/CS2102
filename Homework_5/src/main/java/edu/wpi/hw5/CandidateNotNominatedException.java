package edu.wpi.hw5;

/**
 * This exception is thrown when a vote is cast for a candidate that has not
 * been nominated
 */
public class CandidateNotNominatedException extends Exception {

    /** The name of the candidate that was not nominated */
    private String candidateName;

    /**
     * Creates a new CandidateNotNominatedException
     *
     * @param candidateName The name of the candidate that was not nominated
     */
    public CandidateNotNominatedException(String candidateName) {
        super(String.format("%s was not nominated", candidateName));
        this.candidateName = candidateName;
    }

    /**
     * Gets the name of the candidate that was not nominated
     *
     * @return The name of the candidate that was not nominated
     */
    public String getCandidate() {
        return candidateName;
    }
}
