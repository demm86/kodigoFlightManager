package projectSolid.Interfaces;

import projectSolid.Entities.City;
import projectSolid.Entities.Country;

import java.util.List;

public interface ICityServices {
    List<City> setCity(List<Country> list);
    void printElements(List<City> list);
    List<City> elementsByCountry(int idCountry,List<City> list);

}
