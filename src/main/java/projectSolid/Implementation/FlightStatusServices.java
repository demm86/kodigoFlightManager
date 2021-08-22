package projectSolid.Implementation;

import projectSolid.Entities.Country;
import projectSolid.Entities.Flight;
import projectSolid.Entities.FlightStatus;
import projectSolid.Interfaces.IFlightStatusServices;

import java.util.ArrayList;
import java.util.List;

public class FlightStatusServices implements IFlightStatusServices {
    @Override
    public List<FlightStatus> setElements() {
        List<FlightStatus> flightStatus = new ArrayList<>();

        flightStatus.add(new FlightStatus(1, "PRK", "Parked"));
        flightStatus.add(new FlightStatus(2, "ONT", "On Time"));
        flightStatus.add(new FlightStatus(3, "DLY", "Delayed"));
        flightStatus.add(new FlightStatus(3, "CND", "Canceled"));

        return flightStatus;
    }

    @Override
    public FlightStatus getFlightStatus(int idFlightStatus, List<FlightStatus> list) {
        FlightStatus flightStatus = new FlightStatus();
        for(FlightStatus f : list){
            if(f.getId() == idFlightStatus){
                flightStatus = f;
            }
        }
        return flightStatus;
    }

    @Override
    public void printElements(List<FlightStatus> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("FLIGHT STATUS LIST\n");
        sb.append("---------------------------------\n");
        for(FlightStatus flightStatus : list){
            sb.append("ID: ").append(flightStatus.getId()).append(" |");
            sb.append("CODE: ").append(flightStatus.getCode()).append(" |");
            sb.append("NAME: ").append(flightStatus.getName()).append("\n");
        }
        System.out.println(sb);
    }
}
