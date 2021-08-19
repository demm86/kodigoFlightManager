package projectSolid.Interfaces;

import projectSolid.Entities.Aircraft;
import projectSolid.Entities.Airport;

import java.util.List;

public interface IAircraftServices {
    List<Aircraft> setElements();
    void printElements(List<Aircraft> list);
}
