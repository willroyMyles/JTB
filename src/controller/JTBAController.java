package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class JTBAController {

    @FXML
    Label label;

    @FXML
    private void addPlace() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/views/addPlace.fxml"));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(label.getScene().getWindow());
        stage.showAndWait();
    }

    @FXML
    private void viewAllPlaces(){

    }

    @FXML
    private void viewRequestLog(){

    }

    @FXML
    private void viewProcessedLogs(){

    }

}
