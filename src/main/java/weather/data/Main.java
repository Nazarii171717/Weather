package weather.data;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NonNull
@ToString
public class Main {

    float temp;
    double feels_like;
    double temp_min;
    double temp_max;
    int pressure;
    int humidity;
    int sea_level;
    int grnd_level;
}
