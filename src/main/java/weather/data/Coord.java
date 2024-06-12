package weather.data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NonNull
@ToString
public class Coord {
    double lon;
    double lat;
}
