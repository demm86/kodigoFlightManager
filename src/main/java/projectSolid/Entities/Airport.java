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

    public Airport(){

    }

    public Airport(int id, String code, String name){
        id = this.id;
        code = this.code;
        name = this.name;

    }
}
