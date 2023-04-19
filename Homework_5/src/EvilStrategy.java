import java.util.HashMap;
import java.util.Optional;

/**
 * An evil strategy that attempts to clear the votes
 * This strategy is not used in the actual "election"
 * It is used to test encapsulation
 */
public class EvilStrategy implements I3VoteStrategy {
    public Optional<String> calculateWinner(HashMap<String, Votes> votes) {
        // Attempt to clear the votes
        votes.clear();
        return Optional.empty();
    }
}
