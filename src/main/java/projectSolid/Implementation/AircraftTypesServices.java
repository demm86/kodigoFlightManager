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
        aircraftTypes.add(new AircraftType(1,"AB1","A318-100 Airbus"));
        aircraftTypes.add(new AircraftType(2,"AB2","A319-100 Airbus"));
        aircraftTypes.add(new AircraftType(3,"AB3","A320-100 Airbus"));
        aircraftTypes.add(new AircraftType(4,"AB4","A340-200 Airbus"));
        aircraftTypes.add(new AircraftType(5,"AB5","A350-800 Airbus"));
        aircraftTypes.add(new AircraftType(6,"BNG1","717-200 Boeing"));
        aircraftTypes.add(new AircraftType(7,"BNG2","757-200PF Boeing"));
        aircraftTypes.add(new AircraftType(8,"BNG3","737-300 Boeing"));
        aircraftTypes.add(new AircraftType(9,"BNG4","747-400BCF Boeing"));
        aircraftTypes.add(new AircraftType(10,"BNG5","757-300 Boeing"));

        return aircraftTypes;
    }

    @Override
    public void printElements(List<AircraftType> list) {
        //Titulo de la lista
        StringBuilder sb = new StringBuilder();
        sb.append("AIRCRAFT LIST\n");
        sb.append("__________________________\n");
        for (AircraftType aircraftType: list) {
            sb.append("ID: ").append(aircraftType.getId()).append(" |");
            sb.append("CODE: ").append(aircraftType.getCode()).append(" |");
            sb.append("NAME: ").append(aircraftType.getName()).append(" \n");
            //Datos de la lista
        }
        System.out.println(sb);
        //Imprimir el objeto de StringBuilder
    }
}
