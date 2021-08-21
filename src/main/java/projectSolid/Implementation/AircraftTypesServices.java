package projectSolid.Implementation;

import projectSolid.Entities.AircraftType;
import projectSolid.Interfaces.IAircraftTypeServices;

import java.util.ArrayList;
import java.util.List;

public class AircraftTypesServices implements IAircraftTypeServices {
    @Override
    public List<AircraftType> setAircraftType() {
        List<AircraftType> aircraftTypes = new ArrayList<>();

        //setear la lista

        return aircraftTypes;
    }

    @Override
    public void printElements(List<AircraftType> list) {
        //Titulo de la lista
        for (AircraftType AircraftType: list) {
            //Datos de la lista
        }
        //Imprimir el objeto de StringBuilder
    }
}
