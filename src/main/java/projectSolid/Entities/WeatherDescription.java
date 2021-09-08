package projectSolid.Entities;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;


@Data
public class WeatherDescription {
    private static final String JSON_MAIN        = "main";
    private static final String JSON_DESCRIPTION = "description";

    private final String main;
    private final String description;

    public WeatherDescription (JSONArray json) {
        JSONObject description = json.optJSONObject(0);
        this.main = description.optString(WeatherDescription.JSON_MAIN);
        this.description = description.optString(WeatherDescription.JSON_DESCRIPTION);
    }
}
