package projectSolid;

import projectSolid.Service.Menu;
import projectSolid.Service.Weather.OpenWeatherClient;

import java.io.IOException;


public class Main {
    public static Menu menu = new Menu();
    public static OpenWeatherClient openWeatherClient = new OpenWeatherClient();

    public static void main(String[] args){

        try {
            openWeatherClient.forecastWeatherAtCity("SLV");

        } catch (IOException e) {
            e.printStackTrace();
        }

        menu.shoMenu();



    }
}
