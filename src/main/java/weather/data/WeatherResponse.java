package weather.data;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NonNull
@ToString
public class WeatherResponse {
    Coord coord;
    List<Weather> weather;
    String base;
    Main main;
    int visibility;
    Wind wind;
    Clouds clouds;
    long dt;
    Sys sys;
    int timezone;
    int id;
    String name;
    int cod;
}

