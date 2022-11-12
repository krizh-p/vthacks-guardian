package com.vthacks.vthacksguardian;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onFileScanButtonClick() throws IOException {
    //welcomeText.setText("File Scan!!!"); //temp
        Stage newWindow = new Stage();
        newWindow.setTitle("File Scan");
        //Create view from FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("filescan-view.fxml"));
        //Set view in window
        newWindow.setScene(new Scene(loader.load()));
        //Launch
        newWindow.show();
    }
    @FXML
    protected void onSocialTraceButtonClick() throws IOException {
        //welcomeText.setText("Social Media Trace!!!"); //temp
        Stage newWindow = new Stage();
        newWindow.setTitle("Social Media Trace");
        //Create view from FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("trace-view.fxml"));
        //Set view in window
        newWindow.setScene(new Scene(loader.load()));
        //Launch
        newWindow.show();
    }
    @FXML
    protected void onEmailButtonClick() throws IOException {
        //welcomeText.setText("Email Security!!!"); //temp
        Stage newWindow = new Stage();
        newWindow.setTitle("Email Security");
        //Create view from FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("email-view.fxml"));
        //Set view in window
        newWindow.setScene(new Scene(loader.load()));
        //Launch
        newWindow.show();
    }
}