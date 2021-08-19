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


    public Aircraft(int id, String model){
        this.ID = id;
        this.model = model;

    }

    public Aircraft(){

    }


}
