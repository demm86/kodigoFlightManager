package projectSolid.Interfaces;

import projectSolid.Entities.Country;
import projectSolid.Entities.Flight;
import projectSolid.Entities.FlightStatus;

import java.util.List;

public interface IFlightStatusServices {

    List<FlightStatus> setElements();
    void printElements(List<FlightStatus> list);
}
