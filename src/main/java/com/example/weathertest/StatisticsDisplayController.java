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

import static com.example.weathertest.Main.statisticsDisplay;

public class StatisticsDisplayController {
    @FXML
    private Button switchToFirstPage;
    @FXML
    private Button switchToCurrentWeatherDisplay;
    @FXML
    private Button switchToWindDisplay;

    @FXML
    private Label minTemp;
    @FXML
    private Label maxTemp;
    @FXML
    private Label averageTemp;
    @FXML
    public void onUpdateButtonClick()
    {
        updating();
        minTemp.setText(String.valueOf(statisticsDisplay.getMinTemp()));
        maxTemp.setText(String.valueOf(statisticsDisplay.getMaxTemp()));
        averageTemp.setText(String.valueOf(statisticsDisplay.getAverageTemp()));
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

        minTemp.setText(String.valueOf(statisticsDisplay.getMinTemp()));
        maxTemp.setText(String.valueOf(statisticsDisplay.getMaxTemp()));
        averageTemp.setText(String.valueOf(statisticsDisplay.getAverageTemp()));

        switchToCurrentWeatherDisplay.setOnAction(e -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("currentWeather.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) switchToCurrentWeatherDisplay.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
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