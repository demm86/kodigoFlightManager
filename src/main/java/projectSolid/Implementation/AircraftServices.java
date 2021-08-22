package projectSolid.Implementation;

import projectSolid.Entities.*;
import projectSolid.Interfaces.IAircraftServices;

import java.util.ArrayList;
import java.util.List;

public class AircraftServices implements IAircraftServices {
    @Override
    public List<Aircraft> setElements(List<Airline> airlineList, List<AircraftType> aircraftTypeList) {
        List<Aircraft> aircrafts = new ArrayList<>();

        return null;
    }

    @Override
    public void printElements(List<Aircraft> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("AIRCRAFT LIST\n");
        sb.append("-----------------------------------------------\n");
        for(Aircraft aircraft : list){
            sb.append("ID: ").append(aircraft.getId()).append(" |");
            sb.append("MODEL: ").append(aircraft.getModel()).append(" |");
            sb.append("PASSENGER CAPACITY: ").append(aircraft.getPassengerCapacity()).append(" |");
            sb.append("RANGE: ").append(aircraft.getRange()).append(" |");
            sb.append("TANK CAPACITY: ").append(aircraft.getTankCapacity()).append(" |");
            sb.append("AIRLINE").append(aircraft.getAirline().getName()).append(" |");
            sb.append("AIRCRAFT TYPE").append(aircraft.getAircraftType().getName()).append("\n");
        }
        System.out.println(sb);
    }
}
