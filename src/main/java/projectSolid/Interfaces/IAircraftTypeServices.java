package projectSolid.Interfaces;

import projectSolid.Entities.Aircraft;
import projectSolid.Entities.AircraftType;

import java.util.List;

public interface IAircraftTypeServices {

    List<AircraftType> setAircraftType();
    void printElements(List<AircraftType> list);
}
