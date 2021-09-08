package projectSolid.Service.Weather;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;

import projectSolid.Entities.WeatherDescription;
import projectSolid.Entities.WeatherMain;
import projectSolid.Entities.Wind;

@Data
public class WeatherForecastResponse  {

    public static class Sys {
        private static final String JSON_COUNTRY    = "country";
        private static final String JSON_POPULATION = "population";

        private final String country;
        private final int population;

        public Sys (JSONObject json) {
            this.country = json.optString (Sys.JSON_COUNTRY);
            this.population = json.optInt (Sys.JSON_POPULATION, Integer.MIN_VALUE);
        }

        public boolean hasCountry () {
            return this.country != null && this.country.length () > 0;
        }
        public String getCountry () {
            return this.country;
        }

        public boolean hasPopulation () {
            return this.population != Integer.MIN_VALUE;
        }
        public int getPopulation () {
            return this.population;
        }
    }

    static private final String JSON_URL       = "url";
    static private final String JSON_CITY      = "name";
    static private final String JSON_UNITS     = "units";
    static private final String JSON_MODEL     = "model";
    private static final String JSON_SYS       = "sys";
    private static final String JSON_MAIN      = "main";
    private static final String JSON_WEATHER   = "weather";
    private static final String JSON_WIND      = "wind";

    private String url;
    private String city;
    private String units;
    private String model;
    private Sys sys;
    private Wind wind;
    private WeatherMain main;
    private WeatherDescription weatherDescription;


    public WeatherForecastResponse () {
    }

    public WeatherForecastResponse (JSONObject json) {
        //super (json);
        JSONObject jsonMain = json.optJSONObject (WeatherForecastResponse.JSON_MAIN);
        JSONObject jsonWind = json.optJSONObject (WeatherForecastResponse.JSON_WIND);
        JSONArray jsonWeather = json.optJSONArray (WeatherForecastResponse.JSON_WEATHER);

        this.wind = new Wind(jsonWind);
        this.main = new WeatherMain(jsonMain);
        this.weatherDescription = new WeatherDescription(jsonWeather);


        this.url = json.optString (WeatherForecastResponse.JSON_URL);
        this.city = json.optString (WeatherForecastResponse.JSON_CITY);;
        this.units = json.optString (WeatherForecastResponse.JSON_UNITS);
        this.model = json.optString (WeatherForecastResponse.JSON_MODEL);

        JSONObject jsonSys = json.optJSONObject (WeatherForecastResponse.JSON_SYS);
        this.sys = jsonSys != null ? new Sys (jsonSys) : null;

    }

    public void printElements() {
        System.out.println("-----------------------------------------");
        System.out.println("City: "+this.getCity());
        System.out.println("Weather: " + this.weatherDescription.getMain() +" - "+this.weatherDescription.getDescription());
        System.out.println("-----------------------------------------");
        System.out.println("Temp --> Current :"+this.main.getTemperature()+" Feels Like: "+ this.main.getFeels_like() );
        System.out.println("Wind --> Speed: "+this.wind.getSpeed()+" Angle: "+ this.wind.getDeg()+ " Gust: " +this.wind.getGust());
        System.out.println("-----------------------------------------");

    }

}



