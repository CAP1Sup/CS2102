import java.util.HashMap;
import java.util.Optional;

/**
 * Calculates the winner of the election using the most first votes strategy
 * Winner must have more than 50% of the votes
 */
public class MostFirstVotesStrategy implements I3VoteStrategy {

    /**
     * Calculates the winner of the election using the most first votes strategy
     * Winner must have more than 50% of the votes
     *
     * @param votes The votes for each candidate
     */
    @Override
    public Optional<String> calculateWinner(HashMap<String, Votes> votes) {

        // Declare variables for storing important info
        // A candidate will never have less than 0 votes, so the first candidate will
        // always be entered into the topCandidate entries
        int totalVotes = 0;
        String topCandidate = "";
        int topCandidateVotes = -1;

        // Search through the candidates, finding the one with the most first votes and
        // calculating the total
        for (String candidate : votes.keySet()) {
            if (votes.get(candidate).getFirstVotes() > topCandidateVotes) {
                topCandidate = candidate;
                topCandidateVotes = votes.get(candidate).getFirstVotes();
            }
            totalVotes += votes.get(candidate).getFirstVotes();
        }

        // Check to make sure that this candidate has the majority of the votes
        if (topCandidateVotes > (totalVotes / 2)) {
            return Optional.of(topCandidate);
        } else {
            return Optional.empty();
        }
    }

}
