package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import model.MainAttraction;
import model.ParishCode;
import model.Place;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPlaceController implements Initializable {
    @FXML
    TextField name, address, description, coe, openingHours, contact;
    @FXML
    ChoiceBox parishChoice, mainAttractionChoice;
    @FXML
    ImageView image;


    @FXML
    private void chooseImage() throws MalformedURLException {
        FileChooser fc = new FileChooser();
        File imageFile = fc.showOpenDialog(name.getScene().getWindow());
        if(imageFile != null){
            System.out.print(imageFile.getName());
            //set image
            image.setImage(new Image(String.valueOf(imageFile.toURI().toURL())));
        }else{
            return;
        }
    }

    @FXML
    private void addPlace(){
        Place p = new Place();
        p.setName(name.getText());
        p.setAddress(address.getText());
        p.setDescription(description.getText());
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> parishCodes = FXCollections.observableArrayList(
                ParishCode.getParish(1),
                ParishCode.getParish(2),
                ParishCode.getParish(3),
                ParishCode.getParish(4),
                ParishCode.getParish(5),
                ParishCode.getParish(6),
                ParishCode.getParish(7),
                ParishCode.getParish(8),
                ParishCode.getParish(9),
                ParishCode.getParish(10),
                ParishCode.getParish(11),
                ParishCode.getParish(12),
                ParishCode.getParish(13));
        parishChoice.setItems(parishCodes);

        ObservableList<String> attraction = FXCollections.observableArrayList(MainAttraction.JerkChicken.name(),MainAttraction.RiverTours.name(), MainAttraction.WaterSlides.name());
        mainAttractionChoice.setItems(attraction);

    }
}
