package projectSolid.Implementation;

import projectSolid.Entities.City;
import projectSolid.Entities.Country;
import projectSolid.Interfaces.ICityServices;

import java.util.ArrayList;
import java.util.List;

public class CityServices implements ICityServices {

    @Override
    public  List<City> setCity(List<Country> list) {
        List<City> cities = new ArrayList<>();

        cities.add(new City(1, "SAL", "San Salvador", list.get(0) ));

        cities.add(new City(2, "LAX", "Los Angeles",list.get(1)));
        cities.add(new City(3, "MIA", "Miami", list.get(2)));

        return cities;

    }

    @Override
    public List<City> elementsByCountry(int idCountry,List<City> list) {
        List<City> citiesByCountry = new ArrayList<>();
        for(City city: list){
            if(city.getCountry().getId() == idCountry){
                citiesByCountry.add(city);
            }
        }
        return citiesByCountry;
    }

    @Override
    public void printElements(List<City> list) {
        System.out.println("City list:"+list);
    }
}
