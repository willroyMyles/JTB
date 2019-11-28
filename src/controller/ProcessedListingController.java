package controller;

import fileOperations.FileProcess;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Request;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProcessedListingController implements Initializable {

    @FXML
    TableColumn cfname, clname, cemail, cattraction, cmessage, cdate, cbutton;
    @FXML
    TableView table;
    @FXML
    Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillTable();
    }
    @FXML
    private void close(){
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.hide();
    }

    private void fillTable(){
        cfname.setCellValueFactory(new PropertyValueFactory("firstName"));
        clname.setCellValueFactory(new PropertyValueFactory("lastName"));
        cemail.setCellValueFactory(new PropertyValueFactory("email"));
        cattraction.setCellValueFactory(new PropertyValueFactory("attractionName"));
        cmessage.setCellValueFactory(new PropertyValueFactory("message"));
        cdate.setCellValueFactory(new PropertyValueFactory("datetimeString"));
        cbutton.setCellValueFactory(new PropertyValueFactory("processed"));

        ArrayList<Request> list = new ArrayList<Request>();
        list = FileProcess.treeList.getRequestlistProcessed(FileProcess.treeList.root, list);
        table.setItems(FXCollections.observableList(list));

    }
}
