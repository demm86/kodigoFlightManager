package projectSolid.Entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Country {
    private int id;
    private String code;
    private String name;

    public Country(){}

    public Country(int id, String code, String name){
        this.id = id;
        this.code = code;
        this.name = name;
    }
}
