package projectSolid.Service.Weather;

import java.io.IOException;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OpenWeatherClientTest {
    public static OpenWeatherClient openWeatherClient = new OpenWeatherClient();

    OpenWeatherClientTest() {
    }

    @Test
    void forecastWeatherAtCity() throws IOException, JSONException {
        new WeatherForecastResponse();
        WeatherForecastResponse wf = openWeatherClient.forecastWeatherAtCity("San Salvador");
        Assertions.assertEquals("San Salvador", wf.getCity());
        Assertions.assertTrue(wf.getCity().length() > 0);
        Assertions.assertFalse(wf.getCity().isBlank());
        Assertions.assertFalse(wf.getCity().isEmpty());
    }
}
