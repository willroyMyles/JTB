package controller;

import fileOperations.FileProcess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Place;


import java.net.URL;
import java.util.ResourceBundle;

public class ViewAllPlacesController implements Initializable {
    @FXML
    TableColumn cid, cname, cdescription,caddress,cparish,cattraction,ccontact,ccost,chours,cphoto;
    @FXML
    TableView table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //populate table on load

        //SCCost.setCellValueFactory(new PropertyValueFactory("cost"));ObservableList<PsuedoCourse> proData = FXCollections.observableList(list);
        cid.setCellValueFactory(new PropertyValueFactory("guid"));
        cname.setCellValueFactory(new PropertyValueFactory("name"));
        cdescription.setCellValueFactory(new PropertyValueFactory("description"));
        caddress.setCellValueFactory(new PropertyValueFactory("address"));
        cparish.setCellValueFactory(new PropertyValueFactory("parishCode"));
        cattraction.setCellValueFactory(new PropertyValueFactory("mainAttraction"));
        ccontact.setCellValueFactory(new PropertyValueFactory("contactNumber"));
        ccost.setCellValueFactory(new PropertyValueFactory("costForEntry"));
        chours.setCellValueFactory(new PropertyValueFactory("openingHours"));



        cphoto.setCellValueFactory(new PropertyValueFactory("button"));

        table.setItems(FXCollections.observableList(FileProcess.list));
        System.out.print(FileProcess.list);


    }




}
