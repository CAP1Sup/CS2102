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
            electionData.submitVote(this.vote1.getText(), this.vote2.getText(), this.vote3.getText());
            this.vote1.setText("");
            this.vote2.setText("");
            this.vote3.setText("");

        } catch (CandidateNotNominatedException error) {
            Alert confirmation = new Alert(AlertType.CONFIRMATION);
            confirmation.setHeaderText("Error voting for candidate");
            confirmation.setContentText(error.getMessage() + "\nWould you like to nominate them?");
            Optional<ButtonType> result = confirmation.showAndWait();
            if (result.get() == ButtonType.OK) {
                try {
                    electionData.nominateCandidate(error.getCandidate());
                    onVoteClick();
                } catch (AlreadyNominatedException e1) {
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("Error voting for candidate");
                    errorAlert.setContentText(e1.getMessage());
                    errorAlert.showAndWait();
                }
            }
        } catch (MoreThanOnceException e) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Error voting for candidate");
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
        }
    }

    @FXML
    protected void onNominateClick() {
        // TODO: Use this.nominate.getText() to pass data to your ElectionData field and
        // nominate a candidate
        try {
            electionData.nominateCandidate(this.nominate.getText());
            this.nominate.setText("");
        } catch (AlreadyNominatedException e) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Error nominating candidate");
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
        }
    }

    @FXML
    protected void onWinnerClick() {
        // TODO: Use winner.setText(...) to pass data from your ElectionData field to
        // the GUI
        Optional<String> winner = electionData.calculateWinner();
        if (winner.isPresent()) {
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