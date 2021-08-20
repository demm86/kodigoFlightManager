package projectSolid.Interfaces;

import projectSolid.Entities.Airport;
import projectSolid.Entities.City;
import projectSolid.Entities.Country;

import java.util.List;

public interface IAirportServices {
    List<Airport> setAirport(List<City> list);
    void printElements(List<Airport> list);

}
