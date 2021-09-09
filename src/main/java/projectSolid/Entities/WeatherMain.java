package projectSolid.Entities;

import lombok.Data;
import org.json.JSONObject;
import projectSolid.Service.Weather.WeatherForecastResponse;

import java.math.BigDecimal;

@Data
public class WeatherMain {

    private static final String JSON_TEMPERATURE        = "temp";
    private static final String JSON_TEMPERATURE_MIN    = "temp_min";
    private static final String JSON_TEMPERATURE_MAX    = "temp_max";
    private static final String JSON_FEELS_LIKE         = "feels_like";
    private static final String JSON_GROUND_LEVEL       = "grnd_level";
    private static final String JSON_HUMIDITY           = "humidity";
    private static final String JSON_PRESSURE           = "pressure";
    private static final String JSON_SEA_LEVEL          = "sea_level";


    private final BigDecimal temperature;
    private final BigDecimal temperature_min;
    private final BigDecimal temperature_max;
    private final BigDecimal feels_like;

    private final int ground_level;
    private final int humidity;
    private final int pressure;
    private final int sea_level;



    public WeatherMain (JSONObject json) {
        this.temperature = json.optBigDecimal (WeatherMain.JSON_TEMPERATURE,BigDecimal.ZERO);
        this.temperature_min = json.optBigDecimal (WeatherMain.JSON_TEMPERATURE_MIN, BigDecimal.ZERO);
        this.temperature_max = json.optBigDecimal (WeatherMain.JSON_TEMPERATURE_MAX, BigDecimal.ZERO);
        this.feels_like = json.optBigDecimal (WeatherMain.JSON_FEELS_LIKE, BigDecimal.ZERO);
        this.ground_level = json.optInt (WeatherMain.JSON_GROUND_LEVEL, Integer.MIN_VALUE);
        this.humidity = json.optInt (WeatherMain.JSON_HUMIDITY, Integer.MIN_VALUE);
        this.pressure = json.optInt (WeatherMain.JSON_PRESSURE, Integer.MIN_VALUE);
        this.sea_level = json.optInt (WeatherMain.JSON_SEA_LEVEL, Integer.MIN_VALUE);
    }
}
