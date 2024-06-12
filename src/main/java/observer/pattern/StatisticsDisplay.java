package observer.pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StatisticsDisplay implements Display, Observer{
    private float minTemp;
    private float maxTemp;
    private float averageTemp;
    @Override
    public void display() {
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
    }
}
