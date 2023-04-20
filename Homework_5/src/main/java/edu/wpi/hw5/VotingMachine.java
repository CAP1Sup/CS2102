package edu.wpi.hw5;

import java.util.Optional;
import java.util.Scanner;

/**
 * The main class for the voting machine
 */
public class VotingMachine {

    // Election data handler
    private static ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());

    // System input
    private static Scanner ioScanner = new Scanner(System.in);

    // If to continue prompting the user
    private static boolean continuePrompting = true;

    public static void main(String[] args) {

        // Loop forever
        while (continuePrompting) {

            // Print the current candidates
            System.out.println("The current candidates are:");
            for (String candidate : electionData.getCandidates()) {
                System.out.println(String.format(" - %s", candidate));
            }

            // Ask for a command
            System.out.println(
                    "Do you want to [n]ominate someone, [v]ote for someone, change winner [s]trategy, see who [w]on, or [q]uit?");

            // Check if a valid command has been given
            switch (ioScanner.nextLine().toLowerCase().charAt(0)) {
                case 'n': {
                    // Prompt for who to nominate
                    System.out.println("Please enter the candidate's name:");

                    // Get the user's response
                    String candidateName = ioScanner.nextLine();

                    // Try to nominate the candidate
                    attemptCandidateNomination(candidateName);

                    // Break the switch
                    break;
                }
                case 'v': {
                    // Get first vote
                    System.out.println("Please enter your first vote:");

                    // Save the first vote
                    String firstVote = ioScanner.nextLine();

                    // Get the second vote
                    System.out.println("Please enter your second vote:");

                    // Save the second vote
                    String secondVote = ioScanner.nextLine();

                    // Get the third vote
                    System.out.println("Please enter your third vote:");

                    // Save the third vote
                    String thirdVote = ioScanner.nextLine();

                    // Attempt to submit the vote
                    try {
                        electionData.submitVote(firstVote, secondVote, thirdVote);
                    } catch (CandidateNotNominatedException e) {

                        // Tell the user that the candidate was not nominated
                        System.out.println(e.getMessage());

                        // Ask if they would like to nominate the candidate
                        System.out.println("Would you like to nominate them [y]es/[n]o?");

                        // Check if the user entered a y
                        if (ioScanner.nextLine().toLowerCase().charAt(0) == 'y') {
                            attemptCandidateNomination(e.getCandidate());
                        }

                    } catch (MoreThanOnceException e) {
                        // Let the user know that they're wrong
                        System.out.println(e.getMessage());
                    }

                    // All done
                    break;
                }
                case 's': {
                    // Ask the user which strategy they'd like to use
                    System.out.println("Which strategy would you like to use? Most [f]irst votes or most [a]greeable?");

                    // Check if the input was valid
                    switch (ioScanner.nextLine().toLowerCase().charAt(0)) {
                        case 'f': {
                            electionData.setStrategy(new MostFirstVotesStrategy());
                            break;
                        }
                        case 'a': {
                            electionData.setStrategy(new MostAgreeableStrategy());
                            break;
                        }
                        default: {
                            System.out.println("Not a valid voting method, please try again.");
                        }
                    }

                    // All done
                    break;
                }
                case 'w': {
                    // Calculate the winner
                    Optional<String> winner = electionData.calculateWinner();
                    if (winner.isPresent()) {
                        System.out.println(String.format("%s is the winner", winner.get()));
                    } else {
                        System.out.println("No clear winner under the current strategy");
                    }

                    // All done
                    break;
                }
                case 'q': {
                    // Say thanks
                    System.out.println("Thanks for voting!");

                    // Exit the switch and loop
                    continuePrompting = false;
                    break;
                }
                default: {
                    // Command not recognized
                    System.out.println("Command not recognized");
                }
            }
        }
    }

    /**
     * Attempts to nominate a candidate
     *
     * @param candidateName The name of the candidate to nominate
     */
    private static void attemptCandidateNomination(String candidateName) {
        // Try to nominate the candidate
        try {
            electionData.nominateCandidate(candidateName);
        } catch (AlreadyNominatedException e) {
            System.out.println(e.getMessage());
        }
    }
}
