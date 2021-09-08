package projectSolid;

import projectSolid.Service.Menu;
import projectSolid.Service.Weather.OpenWeatherClient;
import projectSolid.Service.Weather.WeatherForecastResponse;

import java.io.IOException;


public class Main {
    public static Menu menu = new Menu();
    public static OpenWeatherClient openWeatherClient = new OpenWeatherClient();

    public static void main(String[] args){

        try {

            WeatherForecastResponse wf = new WeatherForecastResponse();
            wf = openWeatherClient.forecastWeatherAtCity("San Salvador");
            wf.printElements();



        } catch (IOException e) {
            System.out.println("error: "+ e.toString());
            e.printStackTrace();

        }

        menu.shoMenu();



    }
}
