package projectSolid.Entities;

import lombok.Data;
import projectSolid.Entities.Flight;
import projectSolid.Entities.FlightStatus;

@Data
public class Note {
    private int id;
    private String code;
    private String name;
    private Flight flight;
    private FlightStatus flightStatus;
    private String note;
}
