package projectSolid.Implementation;

import projectSolid.Entities.AircraftType;
import projectSolid.Interfaces.IAircraftTypeServices;

import java.util.ArrayList;
import java.util.List;

public class AircraftTypesServices implements IAircraftTypeServices {
    @Override
    public List<AircraftType> setAircraftType() {
        List<AircraftType> aircraftTypes = new ArrayList<>();

        aircraftTypes.add(new AircraftType(1,"PSG","Passengers"));
        aircraftTypes.add(new AircraftType(2,"CHG","Charge"));
        aircraftTypes.add(new AircraftType(3,"MLT","Military"));
        aircraftTypes.add(new AircraftType(4,"CBT","Combat"));

        return aircraftTypes;
    }

    @Override
    public void printElements(List<AircraftType> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("AIRCRAFT LIST\n");
        sb.append("__________________________\n");
        for (AircraftType aircraftType: list) {
            sb.append("ID: ").append(aircraftType.getId()).append(" |");
            sb.append("CODE: ").append(aircraftType.getCode()).append(" |");
            sb.append("NAME: ").append(aircraftType.getName()).append(" \n");
        }
        System.out.println(sb);
    }
}
