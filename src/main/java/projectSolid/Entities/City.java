package projectSolid.Entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class City {

    private int id;
    private String code;
    private String name;
    private Country country;

    //private List<City> cities = new ArrayList<>();

    public City(int id, String code, String name, Country country){
        this.id = id;
        this.code = code;
        this.name = name;
        this.country = country;
    }

    public City(){
    }



}
