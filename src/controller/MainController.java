package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import presentation.Main;

import java.io.IOException;

public class MainController {

    private AnchorPane root;
    private FXMLLoader loader;

    @FXML
    FlowPane pane;

    @FXML
    PasswordField password;

    @FXML
    private void showPane(){
        pane.setVisible(true);
    }

    @FXML
    private void testPassword(){
        String text = password.getText();
        if(text.compareTo("alpine")==0){
            //continue to load jtb admin view
            //get current stage
            //stage = (Stage) password.getScene().getWindow();
            loader = new FXMLLoader(getClass().getResource("/views/jtba.fxml"));
            Main.genericLoad(loader);
        }
    }

    @FXML
    private void loadVisitorPanel(){
        loader = new FXMLLoader(getClass().getResource("/views/visitor.fxml"));
        Main.genericLoad(loader);
    }





}
