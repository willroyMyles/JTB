package controller;

import fileOperations.FileProcess;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Request;

import java.net.URL;
import java.util.ResourceBundle;

public class RequestController implements Initializable {

    @FXML
    TextField fname, lname, email, attractionName, requestid, dateAndTime, attractionGeneratedId, messageBox;
    @FXML
    Button button;

    Request request = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        request = new Request();
        fillFields(request);

    }

    @FXML
    private void makeRequest(){
        request.setFirstName(fname.getText());
        request.setLastName(lname.getText());
        request.setAttractionName(attractionName.getText());
        request.setMessage(messageBox.getText());

        //hand over to file processor


    }

    private void fillFields(Request request){
        requestid.setText(request.getRequestId());
        attractionGeneratedId.setText(request.getAttractionId());
        dateAndTime.setText(request.getDatetimeString());
        if(FileProcess.lastRequestAttraction != null) attractionName.setText(FileProcess.lastRequestAttraction.name());
    }





}
