package controller;

import fileOperations.FileProcess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import model.MainAttraction;
import model.ParishCode;
import model.Place;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Date;
import java.util.ResourceBundle;
import org.apache.commons.io.FilenameUtils;

public class AddPlaceController implements Initializable {
    @FXML
    TextField name, address, description, coe, openingHours, contact;
    @FXML
    ChoiceBox parishChoice, mainAttractionChoice;
    @FXML
    ImageView image;


    private File imageFile;

    @FXML
    private void chooseImage() throws MalformedURLException {
        FileChooser fc = new FileChooser();
        imageFile = fc.showOpenDialog(name.getScene().getWindow());
        if(imageFile != null){
            System.out.print(imageFile.getName());
            //set image
            image.setImage(new Image(String.valueOf(imageFile.toURI().toURL())));
        }else{
            return;
        }
    }

    @FXML
    private void addPlace() throws IOException {
        Place p = new Place();
        p.setName(name.getText());
        p.setAddress(address.getText());
        p.setDescription(description.getText());
        p.setContactNumber(contact.getText());
        p.setCostForEntry(Integer.parseInt(coe.getText()));
        p.setOpeningHours(openingHours.getText());
        p.setParishCode(parishChoice.getItems().indexOf(parishChoice.getValue()));
        p.setMainAttraction(MainAttraction.values()[mainAttractionChoice.getItems().indexOf(mainAttractionChoice.getValue())]);

        BufferedImage img = null;
        img = ImageIO.read(imageFile);
        String ext = FilenameUtils.getExtension(imageFile.getName());
        String filename = "src/images/"+name.getText()+"."+ext;
        ImageIO.write(img , ext , new File(filename) );

        p.setPhotoLink(filename);
        ImageView photoImage = new ImageView(new File(filename).toURI().toString());
        p.setImage(photoImage);

        FileProcess.list.add(p);
        FileProcess.writePlacesToFile();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> parishCodes = FXCollections.observableArrayList(
                ParishCode.getParish(0),
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
                ParishCode.getParish(12));
        parishChoice.setItems(parishCodes);

        ObservableList<String> attraction = FXCollections.observableArrayList(MainAttraction.JerkChicken.name(),MainAttraction.RiverTours.name(), MainAttraction.WaterSlides.name());
        mainAttractionChoice.setItems(attraction);

    }

    //view all places control



}
