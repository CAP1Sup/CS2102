package edu.wpi.hw5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ElectionData {

    // HashMap of the votes for each candidate
    private HashMap<String, Votes> votes;

    // The strategy for calculating the winner
    private I3VoteStrategy winningVoteStrategy;

    /**
     * Constructor for ElectionData
     *
     * @param winningVoteStrategy The strategy for calculating the winner
     */
    public ElectionData(I3VoteStrategy winningVoteStrategy) {
        votes = new HashMap<String, Votes>(3);
        this.winningVoteStrategy = winningVoteStrategy;
    }

    /**
     * Sets the strategy for calculating the winner
     *
     * @param winningVoteStrategy The strategy for calculating the winner
     */
    public void setStrategy(I3VoteStrategy winningVoteStrategy) {
        this.winningVoteStrategy = winningVoteStrategy;
    }

    /**
     * Gets the available candidates
     *
     * @return The available candidates
     */
    public Set<String> getCandidates() {

        // Create a new HashSet to return
        // Needed to prevent external modification of the internal HashMap
        Set<String> output = new HashSet<String>();
        output.addAll(votes.keySet());
        return output;
    }

    /**
     * Nominates a candidate
     * Throws AlreadyNominatedException if the candidate has already been nominated
     *
     * @param candidate The candidate to nominate
     */
    public void nominateCandidate(String person) throws AlreadyNominatedException {
        if (votes.containsKey(person)) {
            throw new AlreadyNominatedException(person);
        }
        votes.put(person, new Votes(0, 0, 0));
    }

    /**
     * Submits a vote
     * Throws CandidateNotNominatedException if the candidate has not been nominated
     * Throws MoreThanOnceException if the candidate is voted for more than once
     *
     * @param first  The first choice candidate
     * @param second The second choice candidate
     * @param third  The third choice candidate
     */
    public void submitVote(String first, String second, String third)
            throws CandidateNotNominatedException, MoreThanOnceException {

        // Check that the candidates being voted for are nominated
        if (!votes.containsKey(first)) {
            throw new CandidateNotNominatedException(first);
        }
        if (!votes.containsKey(second)) {
            throw new CandidateNotNominatedException(second);
        }
        if (!votes.containsKey(third)) {
            throw new CandidateNotNominatedException(third);
        }

        // Make sure that the candidates are not voted for multiple times in the same
        // vote
        if (first.equals(second)) {
            throw new MoreThanOnceException(first);
        }
        if (second.equals(third)) {
            throw new MoreThanOnceException(second);
        }
        if (first.equals(third)) {
            throw new MoreThanOnceException(first);
        }

        // Increase the candidate votes, respectively
        votes.get(first).voteFirst();
        votes.get(second).voteSecond();
        votes.get(third).voteThird();
    }

    /**
     * Calculates the winner of the election
     *
     * @return The winner of the election
     */
    public Optional<String> calculateWinner() {
        // Make a deep copy of the votes
        HashMap<String, Votes> votesCopy = new HashMap<String, Votes>();
        for (String candidate : votes.keySet()) {
            votesCopy.put(candidate, new Votes(
                    votes.get(candidate).getFirstVotes(),
                    votes.get(candidate).getSecondVotes(),
                    votes.get(candidate).getThirdVotes()));
        }

        return winningVoteStrategy.calculateWinner(votesCopy);
    }
}
