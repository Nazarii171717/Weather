package weather.data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NonNull
@ToString
public class Weather {
    int id;
    String main;
    String description;
    String icon;
}
