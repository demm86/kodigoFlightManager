package projectSolid.Interfaces;

import projectSolid.Entities.Airline;
import projectSolid.Entities.Airport;
import projectSolid.Entities.Country;

import java.util.List;

public interface IAirlineServices {
    List<Airline> setAirline(List<Country> list);
    void printElements(List<Airline> list);
}
