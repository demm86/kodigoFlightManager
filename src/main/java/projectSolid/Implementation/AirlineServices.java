package projectSolid.Implementation;

import projectSolid.Entities.Aircraft;
import projectSolid.Entities.Airline;
import projectSolid.Entities.Country;
import projectSolid.Interfaces.IAirlineServices;

import java.util.ArrayList;
import java.util.List;

public class AirlineServices implements IAirlineServices {
    @Override
    public List<Airline> setAirline(List<Country> list) {
        List<Airline> airlines = new ArrayList<>();
        return airlines;
    }

    @Override
    public void printElements(List<Airline> list) {
        System.out.println("Airlines list:");
        System.out.println("---------------------------------");
        for (Airline Airline: list) {
            System.out.println("ID: " + Airline.getId() + "\n" +
                    "Code: " + Airline.getCode() + "\n"+
                    "Name: " + Airline.getName() + "\n"+
                    "Country: " + Airline.getCountry() + "\n"
                    );

            System.out.println("---------------------------------");
            System.out.println();

        }
    }
}
