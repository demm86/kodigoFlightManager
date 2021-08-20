package projectSolid.Interfaces;

import projectSolid.Entities.Aircraft;
import projectSolid.Entities.AircraftType;
import projectSolid.Entities.Airline;
import projectSolid.Entities.Airport;

import java.util.List;

public interface IAircraftServices {
    List<Aircraft> setElements(List<Airline> airlineList, List<AircraftType> aircraftTypeList);
    void printElements(List<Aircraft> list);
}
