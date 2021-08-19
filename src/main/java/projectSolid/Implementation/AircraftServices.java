package projectSolid.Implementation;

import projectSolid.Entities.Aircraft;
import projectSolid.Entities.Country;
import projectSolid.Entities.Flight;
import projectSolid.Interfaces.IAircraftServices;

import java.util.ArrayList;
import java.util.List;

public class AircraftServices implements IAircraftServices {
    @Override
    public List<Aircraft> setElements() {


        List<Aircraft> aircraftList = new ArrayList<>();

        aircraftList.add(new Aircraft(1, "738"));
        aircraftList.add(new Aircraft(2, "707"));

        return aircraftList;
    }

    @Override
    public void printElements(List<Aircraft> list) {

        System.out.println("Aircraft list:");
        System.out.println("---------------------------------");
        for (Aircraft aircraft: list) {
            System.out.println("ID: " + aircraft.getID() + "\n" +
                               "Model: " + aircraft.getModel() + "\n");

            System.out.println("---------------------------------");
            System.out.println();

        }

    }
}
