module com.example.weathertest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires lombok;
    requires com.google.gson;


    opens com.example.weathertest to javafx.fxml;
    exports com.example.weathertest;
    opens weather.data to com.google.gson;
    exports observer.pattern;
    opens observer.pattern to javafx.fxml;
}