package projectSolid.Implementation;

import projectSolid.Entities.Airline;
import projectSolid.Entities.Airport;
import projectSolid.Entities.City;
import projectSolid.Interfaces.IAirportServices;

import java.util.ArrayList;
import java.util.List;

public class AirportServices implements IAirportServices {
    @Override
    public List<Airport> setAirport(List<City> list) {
        List<Airport> airports = new ArrayList<>();
        return airports;
    }

    @Override
    public void printElements(List<Airport> list) {
        System.out.println("Airports list:");
        System.out.println("---------------------------------");
        for (Airport Airport: list) {
            System.out.println("ID: " + Airport.getId() + "\n" +
                    "Code: " + Airport.getCode() + "\n"+
                    "Name: " + Airport.getName() + "\n"+
                    "City: " + Airport.getCity() + "\n"
            );

            System.out.println("---------------------------------");
            System.out.println();

        }
    }
}
