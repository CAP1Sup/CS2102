package edu.wpi.hw5;

import java.util.HashMap;
import java.util.Optional;

/**
 * Calculates the winner of the election using the most agreeable strategy
 * Winner will be candidate with the most votes in any category
 */
public class MostAgreeableStrategy implements I3VoteStrategy {

    /**
     * Calculates the winner of the election using the most agreeable strategy
     * Winner will be candidate with the most votes in any category
     *
     * @param votes The votes for each candidate
     */
    @Override
    public Optional<String> calculateWinner(HashMap<String, Votes> votes) {
        // Declare variables for storing important info
        // A candidate will never have less than 0 votes, so the first candidate will
        // always be entered into the topCandidate entries
        String topCandidate = "";
        int topCandidateVotes = 0;

        // Search through the candidates, finding the one with the most votes in a
        // single category
        for (String candidate : votes.keySet()) {
            if (votes.get(candidate).getFirstVotes() > topCandidateVotes) {
                topCandidate = candidate;
                topCandidateVotes = votes.get(candidate).getFirstVotes();
            }
            if (votes.get(candidate).getSecondVotes() > topCandidateVotes) {
                topCandidate = candidate;
                topCandidateVotes = votes.get(candidate).getSecondVotes();
            }
            if (votes.get(candidate).getThirdVotes() > topCandidateVotes) {
                topCandidate = candidate;
                topCandidateVotes = votes.get(candidate).getThirdVotes();
            }
        }

        // Check to make sure that topCandidateVotes is not 0
        // If it is, then no candidate has any votes
        if (topCandidateVotes == 0) {
            return Optional.empty();
        } else {
            return Optional.of(topCandidate);
        }
    }

}
