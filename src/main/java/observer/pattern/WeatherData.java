package observer.pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NonNull

public class WeatherData implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        if (! observers.contains(o ))observers.add(o);

    }

    @Override
    public void removeObserver(Observer o) {

        if(observers.contains(o)) observers.remove(o);
    }
}
