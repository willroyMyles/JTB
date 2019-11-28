package model;

import controller.ViewAllPlacesController;
import fileOperations.FileProcess;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

public class Place implements Serializable {

    private String guid;
    private String name;
    private String description;
    private String address;
    private String photoLink;
    private String contactNumber;
    private MainAttraction mainAttraction;
    private int parishCode;
    private int costForEntry;
    private String openingHours;

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    private transient ImageView image;
    private transient Button button = null;

    public Button getButton() {
        return button;
    }

    public Place() {
        this.guid = UUID.randomUUID().toString();
       setupButton(true);
    }

    public void setupButton(boolean action ){
        button = new Button("photo");
        if(action)  button.setOnAction(e->{
            button.setText("Photo");
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/views/blank.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            ((AnchorPane) (root)).getChildren().add(getImage());
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initOwner(scene.getWindow());
            stage.showAndWait();
        });
        //set button to show more
        else button.setOnAction(e->{
            FileProcess.lastRequestAttraction = this.getMainAttraction();

            button.setText("Request Additional Info");
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/views/visitorRequest.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            //sets this main attractuiion to last main attraction

            //((AnchorPane) (root)).getChildren().add(button);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initOwner(scene.getWindow());
            stage.showAndWait();
        });
    }

    public Place(String name, String description, String address, String photoLink, String contactNumber, MainAttraction mainAttraction, int parishCode, int costForEntry, String openingHours) {
        this.guid = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.address = address;
        this.photoLink = photoLink;
        this.contactNumber = contactNumber;
        this.mainAttraction = mainAttraction;
        this.parishCode = parishCode;
        this.costForEntry = costForEntry;
        this.openingHours = openingHours;
        setUpImage();
        setupButton(true);
    }

    public void setUpImage(){
        this.image = new ImageView(new File(photoLink).toURI().toString());
        if(button == null) setupButton(true);
    }

    public String getGuid() {
        return guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public MainAttraction getMainAttraction() {
        return mainAttraction;
    }

    public void setMainAttraction(MainAttraction mainAttraction) {
        this.mainAttraction = mainAttraction;
    }

    public int getParishCode() {
        return parishCode;
    }

    public void setParishCode(int parishCode) {
        this.parishCode = parishCode;
    }

    public int getCostForEntry() {
        return costForEntry;
    }

    public void setCostForEntry(int costForEntry) {
        this.costForEntry = costForEntry;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }


}
