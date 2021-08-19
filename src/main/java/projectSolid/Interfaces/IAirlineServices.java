package projectSolid.Interfaces;

import projectSolid.Entities.Airline;
import projectSolid.Entities.Airport;

import java.util.List;

public interface IAirlineServices {
    List<Airline> setAirline();
    void printElements(List<Airline> list);
}
