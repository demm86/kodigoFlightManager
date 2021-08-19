package projectSolid.Interfaces;

import projectSolid.Entities.City;
import projectSolid.Entities.Country;

import java.util.List;

public interface ICityServices {
    List<City> setElements(List<Country> list);
    List<City> elementsByCountry(int idCountry,List<City> list);
    void printElements(List<City> list);


}
