package com.vthacks.vthacksguardian;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class EmailViewResultsController implements Initializable {

    @FXML
    private Label userSuspicion;

    @FXML
    private Label emailLabel;

    @FXML
    private Label userCredentialsLeak;

    @FXML
    private Label userDataBreach;

    @FXML
    private Label reputationLabel;

    @FXML
    private AnchorPane anchorEmailViewResults;

    @FXML
    private ImageView backgroundViewResults;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        emailLabel.setText(HelloApplication.parsedData.get(0));
        reputationLabel.setText(HelloApplication.parsedData.get(1));
        userSuspicion.setText(HelloApplication.parsedData.get(2));
        userCredentialsLeak.setText(HelloApplication.parsedData.get(3));
        userDataBreach.setText(HelloApplication.parsedData.get(4));
    }
}
