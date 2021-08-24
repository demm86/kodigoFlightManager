package projectSolid.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Airport {
    @Getter @Setter
    private int id;
    @Getter @Setter
    private String code;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private City city;

    public Airport(){}

    public Airport(int id, String code, String name, City city){
        this.id = id;
        this.code = code;
        this.name = name;
        this.city = city;
    }
}
