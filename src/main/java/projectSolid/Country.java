package projectSolid;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Country {
    private int id;
    private String code;
    private String name;

    public Country(int id, String code, String name){
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public List<Country> getCountries(){
        List<Country> countries = new ArrayList<>();

        countries.add(new Country(1, "503", "El Salvador"));
        countries.add(new Country(2, "1", "United States"));
        countries.add(new Country(3, "54", "Argentina"));
        countries.add(new Country(4, "52", "Mexico"));
        countries.add(new Country(5, "56", "Chile"));

        countries.add(new Country(6, "34", "Spain"));
        countries.add(new Country(7, "33", "France"));
        countries.add(new Country(8, "39", "Italy"));
        countries.add(new Country(9, "49", "Germany"));
        countries.add(new Country(10, "374", "Armenia"));

        countries.add(new Country(11, "81", "Japan"));
        countries.add(new Country(12, "82", "South Korea"));
        countries.add(new Country(13, "86", "China"));
        countries.add(new Country(14, "66", "Thailand"));
        countries.add(new Country(15, "91", "India"));

        return countries;
    }
}
