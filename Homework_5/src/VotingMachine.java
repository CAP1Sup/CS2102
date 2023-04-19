import java.util.Scanner;

public class VotingMachine {

    private static ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
    private static Scanner ioScanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Loop forever
        while (true) {

            // Print the current candidates
            System.out.println("The current candidates are:");
            for (String candidate : electionData.getCandidates()) {
                System.out.println(String.format(" - %s", candidate));
            }

            // Ask for a command
            System.out.println(
                    "Do you want to [n]ominate someone, [v]ote for someone, change winner [s]trategy, see who [w]on, or [q]uit?");

            // Wait for the command to be input, then save it
            String command = ioScanner.nextLine();

            // Check if a valid command has been given
            switch (command.charAt(0)) {
                case 'n': {

                    // Nominate someone
                    // Prompt for who to nominate
                    // TODO: Finish
                    System.out.println();

                    break;
                }
            }
        }
    }
}
