package com.vthacks.vthacksguardian;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onFileScanButtonClick() {
        welcomeText.setText("File Scan!!!"); //temp
    }
    @FXML
    protected void onSocialTraceButtonClick() {
        welcomeText.setText("Social Media Trace!!!"); //temp
    }
    @FXML
    protected void onEmailButtonClick() {
        welcomeText.setText("Email Security!!!"); //temp
    }
}