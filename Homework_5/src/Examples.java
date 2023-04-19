import static org.junit.Assert.*;

import java.util.Optional;
import java.util.Set;

import org.junit.Test;

public class Examples {

    // Exception tests
    @Test(expected = AlreadyNominatedException.class)
    public void testMultipleNominations() throws AlreadyNominatedException {
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Bob");
        electionData.nominateCandidate("Bob");
        fail("Should have thrown AlreadyNominatedException");
    }

    @Test(expected = CandidateNotNominatedException.class)
    public void testVoteForNonNominatedFirstCandidate()
            throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Alice");
        electionData.nominateCandidate("Charlie");
        electionData.submitVote("Bob", "Alice", "Charlie");
        fail("Should have thrown CandidateNotNominatedException");
    }

    @Test(expected = CandidateNotNominatedException.class)
    public void testVoteForNonNominatedSecondCandidate()
            throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Bob");
        electionData.nominateCandidate("Alice");
        electionData.submitVote("Bob", "Alice", "Charlie");
        fail("Should have thrown CandidateNotNominatedException");
    }

    @Test(expected = CandidateNotNominatedException.class)
    public void testVoteForNonNominatedThirdCandidate()
            throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Bob");
        electionData.nominateCandidate("Alice");
        electionData.submitVote("Bob", "Alice", "Charlie");
        fail("Should have thrown CandidateNotNominatedException");
    }

    @Test(expected = MoreThanOnceException.class)
    public void testVoteForSameCandidateTwiceFirstSecond()
            throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Bob");
        electionData.nominateCandidate("Alice");
        electionData.submitVote("Bob", "Bob", "Alice");
        fail("Should have thrown MoreThanOnceException");
    }

    @Test(expected = MoreThanOnceException.class)
    public void testVoteForSameCandidateTwiceFirstThird()
            throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Bob");
        electionData.nominateCandidate("Alice");
        electionData.submitVote("Bob", "Alice", "Bob");
        fail("Should have thrown MoreThanOnceException");
    }

    @Test(expected = MoreThanOnceException.class)
    public void testVoteForSameCandidateTwiceSecondThird()
            throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Bob");
        electionData.nominateCandidate("Alice");
        electionData.submitVote("Bob", "Alice", "Alice");
        fail("Should have thrown MoreThanOnceException");
    }

    @Test(expected = MoreThanOnceException.class)
    public void testVoteForSameCandidateTwiceFirstSecondThird()
            throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Bob");
        electionData.nominateCandidate("Alice");
        electionData.submitVote("Bob", "Bob", "Bob");
        fail("Should have thrown MoreThanOnceException");
    }

    // Strategy tests
    @Test
    public void testMostFirstVotesStrategyHasMajority()
            throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Bob");
        electionData.nominateCandidate("Alice");
        electionData.nominateCandidate("Charlie");
        electionData.submitVote("Bob", "Alice", "Charlie");
        electionData.submitVote("Alice", "Charlie", "Bob");
        electionData.submitVote("Alice", "Bob", "Charlie");
        electionData.submitVote("Alice", "Bob", "Charlie");
        electionData.submitVote("Alice", "Bob", "Charlie");
        electionData.submitVote("Charlie", "Bob", "Alice");
        assertEquals(Optional.of("Alice"), electionData.calculateWinner());
    }

    @Test
    public void testMostFirstVotesStrategyNotMajority()
            throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Bob");
        electionData.nominateCandidate("Alice");
        electionData.nominateCandidate("Charlie");
        electionData.submitVote("Bob", "Alice", "Charlie");
        electionData.submitVote("Bob", "Alice", "Charlie");
        electionData.submitVote("Alice", "Bob", "Charlie");
        electionData.submitVote("Alice", "Bob", "Charlie");
        electionData.submitVote("Alice", "Bob", "Charlie");
        electionData.submitVote("Charlie", "Bob", "Alice");
        assertEquals(Optional.empty(), electionData.calculateWinner());
    }

    @Test
    public void testMostAgreeableStrategy()
            throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData electionData = new ElectionData(new MostAgreeableStrategy());
        electionData.nominateCandidate("Bob");
        electionData.nominateCandidate("Alice");
        electionData.nominateCandidate("Charlie");
        electionData.submitVote("Bob", "Alice", "Charlie");
        electionData.submitVote("Bob", "Alice", "Charlie");
        electionData.submitVote("Alice", "Bob", "Charlie");
        electionData.submitVote("Alice", "Bob", "Charlie");
        electionData.submitVote("Alice", "Bob", "Charlie");
        electionData.submitVote("Charlie", "Bob", "Alice");
        assertEquals(Optional.of("Charlie"), electionData.calculateWinner());
    }

    // Test setStrategy
    @Test
    public void testSetStrategy()
            throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Bob");
        electionData.nominateCandidate("Alice");
        electionData.nominateCandidate("Charlie");
        electionData.submitVote("Bob", "Alice", "Charlie");
        electionData.submitVote("Bob", "Alice", "Charlie");
        electionData.submitVote("Alice", "Bob", "Charlie");
        electionData.submitVote("Alice", "Bob", "Charlie");
        electionData.submitVote("Alice", "Bob", "Charlie");
        electionData.submitVote("Charlie", "Bob", "Alice");
        electionData.setStrategy(new MostAgreeableStrategy());
        assertEquals(Optional.of("Charlie"), electionData.calculateWinner());
    }

    // Encapsulation tests
    @Test
    public void testGetCandidatesEncapsulation() throws AlreadyNominatedException {
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Bob");
        Set<String> candidates = electionData.getCandidates();
        candidates.clear();
        assertEquals(1, electionData.getCandidates().size());
    }

    @Test
    public void testCalculateWinnerEncapsulation()
            throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        ElectionData electionData = new ElectionData(new EvilStrategy());
        electionData.nominateCandidate("Bob");
        electionData.nominateCandidate("Alice");
        electionData.nominateCandidate("Charlie");
        electionData.submitVote("Bob", "Alice", "Charlie");
        electionData.submitVote("Alice", "Charlie", "Bob");
        electionData.submitVote("Alice", "Bob", "Charlie");
        electionData.submitVote("Alice", "Bob", "Charlie");
        electionData.submitVote("Alice", "Bob", "Charlie");
        electionData.submitVote("Charlie", "Bob", "Alice");

        // Run the bad strategy, attempting to modify the voting data
        electionData.calculateWinner();
        electionData.setStrategy(new MostFirstVotesStrategy());

        // Run the good strategy, which should still have the proper vote counts (not
        // affected by the evil strategy)
        assertEquals(Optional.of("Alice"), electionData.calculateWinner());
    }

}
