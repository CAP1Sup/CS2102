package edu.wpi.hw5;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.util.Optional;

public class VotingController {
    @FXML
    private Label candidates;

    @FXML
    private TextField vote1;
    @FXML
    private TextField vote2;
    @FXML
    private TextField vote3;

    @FXML
    private Label winner;

    @FXML
    private TextField nominate;

    ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());

    @FXML
    private Label error;

    @FXML
    protected void onVoteClick() {
        try {
            // Attempt to vote for the candidates in the text fields
            electionData.submitVote(this.vote1.getText(), this.vote2.getText(), this.vote3.getText());

            // If no exception is thrown, clear the text fields
            this.vote1.setText("");
            this.vote2.setText("");
            this.vote3.setText("");

        } catch (CandidateNotNominatedException error) {

            // If a CandidateNotNominatedException is thrown, attempt to nominate the
            // candidate
            Alert confirmation = new Alert(AlertType.CONFIRMATION);
            confirmation.setHeaderText("Error voting for candidate");
            confirmation.setContentText(error.getMessage() + "\nWould you like to nominate them?");
            Optional<ButtonType> result = confirmation.showAndWait();

            // Check if the user clicked OK
            if (result.get() == ButtonType.OK) {
                try {
                    // Try to nominate the candidate
                    electionData.nominateCandidate(error.getCandidate());

                    // If no exception is thrown, try to vote for the candidates again
                    onVoteClick();
                } catch (AlreadyNominatedException e1) {

                    // If an AlreadyNominatedException is thrown, show an error alert
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("Error voting for candidate");
                    errorAlert.setContentText(e1.getMessage());
                    errorAlert.showAndWait();
                }
            }
        } catch (MoreThanOnceException e) {
            // If a MoreThanOnceException is thrown, show an error alert
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Error voting for candidate");
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
        }
    }

    @FXML
    protected void onNominateClick() {
        try {
            // Try to nominate the candidate
            electionData.nominateCandidate(this.nominate.getText());

            // If no exception is thrown, clear the text field
            this.nominate.setText("");
        } catch (AlreadyNominatedException e) {
            // If an AlreadyNominatedException is thrown, show an error alert
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Error nominating candidate");
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
        }
    }

    @FXML
    protected void onWinnerClick() {
        // Get the winner
        Optional<String> winner = electionData.calculateWinner();

        // Check if there is a winner
        if (winner.isPresent()) {

            // If there is a winner, set the winner label to the winner
            this.winner.setText(winner.get());
        } else {
            this.winner.setText("No winner");
        }
    }

    @FXML
    protected void onFirstVotesClick() {
        electionData.setStrategy(new MostFirstVotesStrategy());
    }

    @FXML
    protected void onAgreeableClick() {
        electionData.setStrategy(new MostAgreeableStrategy());
    }
}