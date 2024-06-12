package request.atributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import weather.data.WeatherResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class Request {

    @SneakyThrows
    public WeatherResponse makeRequestAndParseData(String city){
    String apiKey = "71e002f665162606eef6508a22c063e7";

    HttpClient client = HttpClient.newBuilder().build();
    String question = "YOUR QUESTION";
    String requestString = """
                {"contents":[{"parts":[{"text": "%s"}]}]}
                """.formatted(question);

    HttpRequest request =
            HttpRequest.newBuilder(
                            new URI("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid="
                                    +apiKey))
                    .header("Content-Type","application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestString))
                    .build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.toString());
        System.out.println(response.body());
        WeatherResponse weatherResponse = null;
        try {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        weatherResponse = gson.fromJson(response.body(), WeatherResponse.class);
        } catch (Exception exception)
        {
            System.out.println("error");
        }
        return weatherResponse;
    }}
