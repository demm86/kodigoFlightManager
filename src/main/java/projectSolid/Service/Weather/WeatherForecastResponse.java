package projectSolid.Service.Weather;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;

import projectSolid.Entities.WeatherDescription;
import projectSolid.Entities.WeatherMain;
import projectSolid.Entities.Wind;

@Data
public class WeatherForecastResponse  {
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
    private Wind wind;
    private WeatherMain main;
    private WeatherDescription weatherDescription;


    public WeatherForecastResponse () {
    }

    public WeatherForecastResponse (JSONObject json) {

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

    public String stringElements() {
        StringBuilder sb = new StringBuilder();
        //sb.append("-----------------------------------------").append("\n");
        //sb.append("City: "+this.getCity()).append(" || ");
        sb.append("Weather: " + this.weatherDescription.getMain() +" - "+this.weatherDescription.getDescription()).append("||").append("\n");
        sb.append("Temp --> Current :"+this.main.getTemperature()+" Feels Like: "+ this.main.getFeels_like() ).append("||");
        sb.append("Wind --> Speed: "+this.wind.getSpeed()+" Angle: "+ this.wind.getDeg()+ " Gust: " +this.wind.getGust()).append("\n");
        sb.append("-----------------------------------------").append("\n");

        return sb.toString();
    }




}



