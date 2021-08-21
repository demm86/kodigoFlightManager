package projectSolid.Entities;

import lombok.Data;

@Data
public class AircraftType {
    private int id;
    private String code;
    private String name;

    public AircraftType(){}

    public AircraftType(int id, String code, String name){
        this.id = id;
        this.code = code;
        this.name = name;
    }
}
