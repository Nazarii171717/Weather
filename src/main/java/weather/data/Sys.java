package weather.data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NonNull
@ToString
public class Sys {
    String country;
    long sunrise;
    long sunset;
}
