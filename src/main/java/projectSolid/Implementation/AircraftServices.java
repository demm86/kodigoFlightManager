package projectSolid.Implementation;

import projectSolid.Entities.*;
import projectSolid.Interfaces.IAircraftServices;

import java.util.ArrayList;
import java.util.List;

public class AircraftServices implements IAircraftServices {
    @Override
    public List<Aircraft> setElements(List<Airline> airlineList, List<AircraftType> aircraftTypeList) {
        List<Aircraft> aircrafts = new ArrayList<>();

        aircrafts.add(new Aircraft(1, "Airbus A320", 180, 6100, 24210, airlineList.get(0), aircraftTypeList.get(0)));
        aircrafts.add(new Aircraft(2, "Airbus A340-200", 261, 14800, 155040, airlineList.get(1), aircraftTypeList.get(0)));
        aircrafts.add(new Aircraft(3, "Boeing 737-200", 118, 3440, 17860, airlineList.get(2), aircraftTypeList.get(0)));
        aircrafts.add(new Aircraft(4, "Boeing 777-200", 440, 9700, 117348, airlineList.get(3), aircraftTypeList.get(1)));
        aircrafts.add(new Aircraft(5, "Lockheed C-130 Hercules", 50, 3800, 150000, airlineList.get(1), aircraftTypeList.get(3)));

        return aircrafts;
    }

    @Override
    public Aircraft getAircraft(int idAircraft, List<Aircraft> list) {
        Aircraft aircraft = new Aircraft();
        for(Aircraft a : list){
            if(a.getId() == idAircraft){
                aircraft = a;
            }
        }
        return aircraft;
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
            sb.append("AIRLINE: ").append(aircraft.getAirline().getName()).append(" |");
            sb.append("AIRCRAFT TYPE: ").append(aircraft.getAircraftType().getName()).append("\n");
        }
        System.out.println(sb);
    }
}
