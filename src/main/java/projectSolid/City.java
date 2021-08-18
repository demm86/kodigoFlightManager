package projectSolid;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class City {

    private int id;
    private String code;
    private String name;
    private Country country;

    private List<City> cities = new ArrayList<>();

    public City(int id, String code, String name, Country country){
        this.id = id;
        this.code = code;
        this.name = name;
        this.country = country;
    }

    public List<City> getCities(Country country){
        setList();
        List<City> citiesByCountry = new ArrayList<>();
        for(City city: cities){
            if(city.country.getId() == country.getId()){
                citiesByCountry.add(city);
            }
        }

        return citiesByCountry;
    }

    public void setList(){
        cities.add(new City(1, "SAL", "San Salvador", new Country(1, "503", "El Salvador")));

        cities.add(new City(2, "LAX", "Los Angeles", new Country(2, "1", "United States")));
        cities.add(new City(3, "MIA", "Miami", new Country(2, "1", "United States")));

        cities.add(new City(4, "AEP", "Buenos Aires", new Country(3, "54", "Argentina")));
        cities.add(new City(5, "COR", "Córdoba", new Country(3, "54", "Argentina")));

        cities.add(new City(6, "MTY", "Monterrey", new Country(4, "52", "Mexico")));
        cities.add(new City(7, "VER", "Veracruz", new Country(4, "52", "Mexico")));

        cities.add(new City(8, "SCL", "Santiago", new Country(5, "56", "Chile")));
        cities.add(new City(9, "CCP", "Concepción", new Country(5, "56", "Chile")));
    }
}
