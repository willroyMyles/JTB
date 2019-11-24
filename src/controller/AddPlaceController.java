package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

public class AddPlaceController {
    @FXML
    TextField name, address, description, coe, openingHours, contact;
    @FXML
    ChoiceBox parishCode, mainAttraction;

    @FXML
    private void chooseImage(){
        FileChooser fc = new FileChooser();
        File image = fc.showOpenDialog(name.getScene().getWindow());
        if(image != null){
            System.out.print(image.getName());
        }else{
            return;
        }
    }

    @FXML
    private void addPlace(){

    }
}
