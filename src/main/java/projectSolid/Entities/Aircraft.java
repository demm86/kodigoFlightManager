package projectSolid.Entities;
import lombok.Data;

@Data
public class Aircraft {
    private int ID;
    private String model;
    private Airline airline;
    private AircraftType aircraftType;
    private int passengerCapacity;
    private int range;
    private double tankCapacity;



}
