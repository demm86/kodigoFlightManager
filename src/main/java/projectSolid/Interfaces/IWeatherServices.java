package projectSolid.Interfaces;


import projectSolid.Entities.WeatherAirport;

import java.util.List;

public interface IWeatherServices {
    List<WeatherAirport> setNote();
    void printElements(List<WeatherAirport> list);
}
