package com.example.weathertest;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import static com.example.weathertest.FirstPageController.city;

import static com.example.weathertest.Main.currentWeatherDisplay;

public class CurrentWeatherDisplayController {

    @FXML
    private Label temp;
    @FXML
    private Label humidity;
    @FXML
    private Label pressure;
    @FXML
    private Label chosenCity;
    @FXML
    private Button switchToWindDisplay;
    @FXML
    private Button switchToStatisticsDisplay;
    @FXML
    private Button switchToFirstPage;

    @FXML
    public void onUpdateButtonClick()
    {
        updating();
        temp.setText(String.valueOf(currentWeatherDisplay.getTemperature()));
        humidity.setText(String.valueOf(currentWeatherDisplay.getHumidity()));
        pressure.setText(String.valueOf(currentWeatherDisplay.getPressure()));
    }
    public void updating()
    {
        Main main = new Main();
        main.createWeatherNote(city);
    }
    public void initialize() {

        KeyFrame keyFrame = new KeyFrame(Duration.minutes(0.1), event -> {
            onUpdateButtonClick();
        });
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        chosenCity.setText(city);
        temp.setText(String.valueOf(currentWeatherDisplay.getTemperature()));
        humidity.setText(String.valueOf(currentWeatherDisplay.getHumidity()));
        pressure.setText(String.valueOf(currentWeatherDisplay.getPressure()));

        switchToWindDisplay.setOnAction(e -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("wind.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) switchToWindDisplay.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        switchToStatisticsDisplay.setOnAction(e -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("statistics.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) switchToStatisticsDisplay.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        switchToFirstPage.setOnAction(e -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) switchToFirstPage.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
