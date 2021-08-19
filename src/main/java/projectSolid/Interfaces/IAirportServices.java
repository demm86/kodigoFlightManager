package projectSolid.Interfaces;

import projectSolid.Entities.Airport;
import projectSolid.Entities.Country;

import java.util.List;

public interface IAirportServices {
    List<Airport> setAirport();
    void printElements(List<Airport> list);

}
