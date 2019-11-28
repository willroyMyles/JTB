package model;

import fileOperations.FileProcess;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Request implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String attractionName;
    private String requestId;
    private String attractionId;
    private String message;
    private String datetimeString;
    private Date date;
    private boolean processed = false;
    private transient Button button;

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(String attractionId) {
        this.attractionId = attractionId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDatetimeString() {
        return datetimeString;
    }

    public void setDatetimeString(String datetimeString) {
        this.datetimeString = datetimeString;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUpButton(){
        button = new Button("process");
        if(isProcessed()) button.setDisable(true);
        button.setOnAction( e->{
            this.processed = true;
            FileProcess.treeList.updateProcessedNode(FileProcess.treeList.root, requestId);
            FileProcess.writeRequestsToFile();
            Stage stage = (Stage) button.getScene().getWindow();
            stage.hide();
        });
    }

    public Request() {
        requestId = UUID.randomUUID().toString();
        attractionId = UUID.randomUUID().toString();

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        date = new Date(System.currentTimeMillis());
        datetimeString = formatter.format(date);
        setUpButton();

    }
}
