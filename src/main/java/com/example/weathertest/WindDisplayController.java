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
import static com.example.weathertest.Main.windDisplay;

public class WindDisplayController {

    @FXML
    private Button switchToFirstPage;

    @FXML
    private Button switchToCurrentWeatherDisplay;
    @FXML
    private Button switchToStatisticsDisplay;
    @FXML
    private Label speed;
    @FXML
    private Label degree;
    @FXML
    private Label gust;
    @FXML
    public void onUpdateButtonClick()
    {
        updating();
        speed.setText(String.valueOf(windDisplay.getSpeed()));
        degree.setText(String.valueOf(windDisplay.getDeg()));
        gust.setText(String.valueOf(windDisplay.getGust()));
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

        speed.setText(String.valueOf(windDisplay.getSpeed()));
        degree.setText(String.valueOf(windDisplay.getDeg()));
        gust.setText(String.valueOf(windDisplay.getGust()));

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
