package weather.data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NonNull
@ToString
public class Wind {
    double speed;
    int deg;
    double gust;
}
