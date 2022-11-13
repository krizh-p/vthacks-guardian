package com.vthacks.vthacksguardian;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SocialTraceController {
    @FXML
    protected void onTraceButtonClick() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Map");
        //Create view from FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("map-view.fxml"));
        //Set view in window
        newWindow.setScene(new Scene(loader.load()));
        //Launch
        newWindow.show();
    }
}
