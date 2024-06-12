package com.example.weathertest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class FirstPageController {

    @FXML
    private Label error;
    @FXML
    private Button getInformation;
    @FXML
    private TextField textField;
    protected static String city;

    public void initialize() {
        getInformation.setOnAction(e -> {

            boolean incorrectName = false;
            city = textField.getText();
            Main main = new Main();
            try {
                main.createWeatherNote(city);
            }
            catch (NullPointerException exception)
            {
                incorrectName = true;
                error.setText("This city does not exist, try again");
            }

            if (!incorrectName){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("currentWeather.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) getInformation.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException ex) {
                ex.printStackTrace();
            }}
        });
    }
}
