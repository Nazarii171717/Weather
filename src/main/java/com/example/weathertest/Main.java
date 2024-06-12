
package com.example.weathertest;

import lombok.Getter;
import observer.pattern.CurrentWeatherDisplay;
import observer.pattern.WindDisplay;
import observer.pattern.StatisticsDisplay;
import observer.pattern.WeatherData;
import request.atributes.Request;
import weather.data.WeatherResponse;

public class Main {
    @Getter
    protected static CurrentWeatherDisplay currentWeatherDisplay;
    @Getter
    protected static StatisticsDisplay statisticsDisplay;
    @Getter
    protected static WindDisplay windDisplay;


    public void createWeatherNote(String city)
    {
        Request request = new Request();
        WeatherResponse weatherResponse = request.makeRequestAndParseData(city);

        WeatherData weatherData = new WeatherData();
        currentWeatherDisplay = new CurrentWeatherDisplay(
                weatherResponse.getMain().getTemp(),
                weatherResponse.getMain().getHumidity(),
                weatherResponse.getMain().getPressure());

        windDisplay = new WindDisplay(
                weatherResponse.getWind().getSpeed(),
                weatherResponse.getWind().getDeg(),
                weatherResponse.getWind().getGust());
        statisticsDisplay = new StatisticsDisplay(
                (float) weatherResponse.getMain().getTemp_min(),
                (float) weatherResponse.getMain().getTemp_max(),
                (float) ((weatherResponse.getMain().getTemp_max()
                                        - weatherResponse.getMain().getTemp_min())
                        / 2 + weatherResponse.getMain().getTemp_min()));

        weatherData.registerObserver(currentWeatherDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(windDisplay);
    }
}


