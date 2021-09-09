package projectSolid.Entities;

import lombok.Data;
import org.json.JSONObject;
import java.math.BigDecimal;

@Data
public class Wind {
    private static final String JSON_DEG    = "deg";
    private static final String JSON_SPEED  = "speed";
    private static final String JSON_GUST   = "gust";

    private final int deg;
    private final BigDecimal speed;
    private final BigDecimal gust;

    public Wind (JSONObject json) {
        this.deg = json.optInt (Wind.JSON_DEG,Integer.MIN_VALUE);
        this.speed = json.optBigDecimal (Wind.JSON_SPEED,BigDecimal.ZERO);
        this.gust = json.optBigDecimal (Wind.JSON_GUST, BigDecimal.ZERO);
    }
}
