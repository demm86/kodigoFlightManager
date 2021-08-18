package projectSolid;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Weather {
    private int id;
    private Airport airport;
    private LocalDateTime dateTime;
    private int hour;
    private double temperature;
    private char temperatureUnit;
    private double humidity;
    private char humidityUnit;
    private String description;

}
