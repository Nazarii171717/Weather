package observer.pattern;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NonNull
public class WindDisplay implements Observer, Display {
        private double speed;
        private int deg;
        private double gust;
    @Override
    public void display() {
    }
    @Override
    public void update(float temperature, float humidity, float pressure) {
    }
}
