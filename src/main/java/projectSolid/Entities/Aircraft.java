package projectSolid.Entities;
import lombok.Data;

@Data
public class Aircraft {
    private int id;
    private String model;
    private int passengerCapacity;
    private int range;
    private double tankCapacity;
    private Airline airline;
    private AircraftType aircraftType;

    public Aircraft(){}

    public Aircraft(int id, String model, int passengerCapacity, int range, double tankCapacity, Airline airline, AircraftType aircraftType){
        this.id = id;
        this.model = model;
        this.passengerCapacity = passengerCapacity;
        this.range = range;
        this.tankCapacity = tankCapacity;
        this.airline = airline;
        this.aircraftType = aircraftType;
    }
}
