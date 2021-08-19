package projectSolid.Implementation;

import projectSolid.Entities.Aircraft;
import projectSolid.Entities.AircraftType;
import projectSolid.Interfaces.IAircraftTypeServices;

import java.util.List;

public class AircraftTypesServices implements IAircraftTypeServices {
    @Override
    public List<AircraftType> setAircraftType() {
        return null;
    }

    @Override
    public void printElements(List<AircraftType> list) {
        System.out.println("Aircraft Type list:");
        System.out.println("---------------------------------");
        for (AircraftType AircraftType: list) {
            System.out.println("ID: " + AircraftType.getId() + "\n" +
                    "Code: " + AircraftType.getCode() + "\n"+
                    "Name: " + AircraftType.getName() + "\n");

            System.out.println("---------------------------------");
            System.out.println();

        }


    }
}
