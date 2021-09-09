package projectSolid.Implementation;

import projectSolid.Entities.WeatherAirport;
import projectSolid.Interfaces.IWeatherServices;

import java.util.List;

public class WeatherServices implements IWeatherServices {
    @Override
    public List<WeatherAirport> setNote() {
        return null;
    }

    @Override
    public void printElements(List<WeatherAirport> list) {
        System.out.println("Weather list:");
        System.out.println("---------------------------------");
        for (WeatherAirport Weather: list) {
            System.out.println("ID: " + Weather.getId() + "\n" +
                    "Airport: " + Weather.getAirport() + "\n"+
                    "LocalDateTime: " + Weather.getDateTime() + "\n"+
                    "Hour: " + Weather.getHour() + "\n"+
                    "Temperature: " + Weather.getTemperature() + "\n"+
                    "TemperatureUnit: " + Weather.getTemperatureUnit() + "\n"+
                    "Humidity: " + Weather.getHumidity() + "\n"+
                    "HumidityUnit: " + Weather.getHumidityUnit() + "\n"+
                    "Description: " + Weather.getDescription() + "\n"
            );

            System.out.println("---------------------------------");
            System.out.println();

        }
    }
}
