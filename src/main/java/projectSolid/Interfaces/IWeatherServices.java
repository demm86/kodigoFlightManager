package projectSolid.Interfaces;


import projectSolid.Entities.Weather;

import java.util.List;

public interface IWeatherServices {
    List<Weather> setNote();
    void printElements(List<Weather> list);
}
