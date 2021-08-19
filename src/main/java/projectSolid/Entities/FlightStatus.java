package projectSolid.Entities;

import lombok.Data;
import lombok.Setter;

@Data
public class FlightStatus {
    private int id;
    private String code;
    private String name;


    public FlightStatus(int id, String code, String name) {
        this.id =id;
        this.code = code;
        this.name = name;
    }

    public FlightStatus(){

    }
}
