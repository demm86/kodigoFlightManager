package projectSolid;

import lombok.Data;

@Data
public class Notes {
    private int id;
    private String code;
    private String name;
    private Flight flight;
    private FlightStatus flightStatus;
    private String note;
}
