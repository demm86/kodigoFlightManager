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

        flightStatus.add(new FlightStatus(1, "CND", "Canceled"));
        flightStatus.add(new FlightStatus(2, "ONT", "On Time"));
        flightStatus.add(new FlightStatus(3, "DLY", "Delayed"));

        return flightStatus;
    }

    @Override
    public void printElements(List<FlightStatus> list) {
        System.out.println("Flight Status list:"+list);
    }
}
