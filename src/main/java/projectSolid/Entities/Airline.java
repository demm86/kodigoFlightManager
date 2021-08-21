package projectSolid.Entities;

import lombok.Data;

@Data
public class Airline {
    private int id;
    private String code;
    private String name;
    private Country country;

    public Airline(){}

    public Airline(int id, String code, String name, Country country){
        this.id = id;
        this.code = code;
        this.name = name;
        this.country = country;
    }
}
