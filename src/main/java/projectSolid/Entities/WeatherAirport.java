package projectSolid.Entities;

import lombok.Data;
import projectSolid.Entities.Airport;

import java.time.LocalDateTime;

@Data
public class WeatherAirport {
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
