package com.vthacks.vthacksguardian;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;


public class EmailViewController implements Initializable {

    @FXML
    private Button emailRunButton;
    @FXML
    private TextField emailTextInput;
    @FXML
    private AnchorPane emailAnchor;
    @FXML
    private ImageView backgroundEmailView;


    @Override
    public void initialize(URL currUrl, ResourceBundle resourceBundle) {
        emailRunButton.setOnMouseClicked(event -> {
            String str = emailTextInput.getText();

            try {
                str = str.replace("@", "%40");
                URL url = new URL("https://emailrep.io/" + str);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET"); //requests
                conn.setRequestProperty("accept", "application/json"); //header
                conn.connect();

                //Check if connect is made
                int responseCode = conn.getResponseCode();

                // 200 OK
                if (responseCode != 200) {
                    throw new RuntimeException("HttpResponseCode: " + responseCode);
                } else {

                    StringBuilder informationString = new StringBuilder();
                    Scanner scanner = new Scanner(url.openStream());

                    while (scanner.hasNext()) {
                        informationString.append(scanner.nextLine());
                    }
                    //Close the scanner
                    scanner.close();

                    System.out.println("Parsed Data: "  + informationString);

                    HelloApplication.parsedData = new ArrayList<>();
                    //JSON simple library Setup with Maven is used to convert strings to JSON
                    JSONParser parse = new JSONParser();
                    JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));

                    //Get the first JSON object in the JSON array
                    JSONObject data = (JSONObject) dataObject.get(0);
                    HelloApplication.parsedData.add((String) data.get("email"));
                    HelloApplication.parsedData.add((String) data.get("reputation"));
                    HelloApplication.parsedData.add((String) data.get("suspicious"));
                    HelloApplication.parsedData.add((String) data.get("credentials_leaked"));
                    HelloApplication.parsedData.add((String) data.get("data_breach"));






                }
            } catch (Exception e) {
                e.printStackTrace();
            }




            Parent rootPlayerSelectScreen = null;
            try {
                rootPlayerSelectScreen = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("email_view_results.fxml")));
                HelloApplication.scene = new Scene(rootPlayerSelectScreen, 620, 540);
                HelloApplication.stage.setScene(HelloApplication.scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
