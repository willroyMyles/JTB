package controller;

import fileOperations.FileProcess;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.MainAttraction;
import model.ParishCode;
import model.Place;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VisitorController {

    @FXML
    Button close, jc, btn;

    @FXML
    TextField input;

    @FXML
    TableColumn cname, cattraction, ccost, cbutton, ccontact;
    @FXML
    TableView table;

    @FXML
    private void listOfJamaicanCreole() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/views/creoleList.fxml"));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(jc.getScene().getWindow());
        stage.showAndWait();
    }

    @FXML
    private void requestListing() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/views/listing.fxml"));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(jc.getScene().getWindow());
        stage.showAndWait();
    }

    @FXML
    private void close(){
       Stage stage = (Stage) close.getScene().getWindow();
       stage.hide();
    }

    @FXML
    private void search(){
        String str = input.getText();

        if(str.contains("gimmi")){
            //get parish name
            List<Place> list = null;
            while(true) {
                if (str.contains(ParishCode.getParish(1))) {
                    list = searchByParish(1);
                    break;
                }
                if (str.contains(ParishCode.getParish(2))) {
                    list = searchByParish(2);
                    break;
                }
                if (str.contains(ParishCode.getParish(3))) {
                    list = searchByParish(3);
                    break;
                }
                if (str.contains(ParishCode.getParish(4))) {
                    list = searchByParish(4);
                    break;
                }
                if (str.contains(ParishCode.getParish(5))) {
                    list = searchByParish(5);
                    break;
                }
                if (str.contains(ParishCode.getParish(6))) {
                    list = searchByParish(6);
                    break;
                }
                if (str.contains(ParishCode.getParish(7))) {
                    list = searchByParish(7);
                    break;
                }
                if (str.contains(ParishCode.getParish(8))) {
                    list = searchByParish(8);
                    break;
                }
                if (str.contains(ParishCode.getParish(9))) {
                    list = searchByParish(9);
                    break;
                }
                if (str.contains(ParishCode.getParish(10))) {
                    list = searchByParish(10);
                    break;
                }
                if (str.contains(ParishCode.getParish(11))) {
                    list = searchByParish(11);
                    break;
                }
                if (str.contains(ParishCode.getParish(12))) {
                    list = searchByParish(12);
                    break;
                }
                if (str.contains(ParishCode.getParish(13))) {
                    list = searchByParish(13);
                    break;
                }
            }

            if(list == null) return;

            //set table

            cname.setCellValueFactory(new PropertyValueFactory("name"));
            cattraction.setCellValueFactory(new PropertyValueFactory("mainAttraction"));
            ccost.setCellValueFactory(new PropertyValueFactory("costForEntry"));
            cbutton.setCellValueFactory(new PropertyValueFactory("button"));
            ccontact.setCellValueFactory(new PropertyValueFactory("contactNumber"));

            for(Place p : list){
                p.setupButton(false);
                p.getButton().setText("Request Additional Info");
            }
            table.setItems(FXCollections.observableList(list));
            return;
        }

        if(str.contains("cheapest")){
            //search by cost

            List<Place> list = null;
            while(true){
                if(str.contains(MainAttraction.RiverTours.name()) || str.contains("river tours")){
                     list = searchByAttraction(MainAttraction.RiverTours);

                    break;
                }
                if(str.contains(MainAttraction.JerkChicken.name()) || str.contains("jerk chicken")){
                     list = searchByAttraction(MainAttraction.JerkChicken);
                    break;
                }
                if(str.contains(MainAttraction.WaterSlides.name()) || str.contains("water slides")){
                    list = searchByAttraction(MainAttraction.WaterSlides);
                    break;
                }
                break;
            }

            if(list == null) return;

            for(Place p : list){
                p.setupButton(false);
                p.getButton().setText("Request Additional Info");
            }

            cname.setCellValueFactory(new PropertyValueFactory("name"));
            cattraction.setCellValueFactory(new PropertyValueFactory("mainAttraction"));
            ccost.setCellValueFactory(new PropertyValueFactory("costForEntry"));
            cbutton.setCellValueFactory(new PropertyValueFactory("button"));
            ccontact.setCellValueFactory(new PropertyValueFactory("contactNumber"));


            table.setItems(FXCollections.observableList(list));

            //set table
        }
    }

    private  ArrayList<Place> searchByAttraction(MainAttraction code){
        return FileProcess.getListByAttraction(code);
    }

    private ArrayList<Place> searchByCost(){
        return FileProcess.getListbyLowestCost();
    }

    private ArrayList<Place> searchByParish(int code){
        return  FileProcess.getListbyParish(code);

    }
}
