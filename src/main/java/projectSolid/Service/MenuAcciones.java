package projectSolid.Service;

import projectSolid.Entities.Flight;
import projectSolid.Implementation.FlightServices;
import projectSolid.Main;

import java.util.Scanner;

public class MenuAcciones {

    public static void getinfoFlight() {

        Flight flight;
        Scanner sc = new Scanner(System.in);
        try {
            flight = new Flight();
            System.out.println("type the flight id");
            flight.setId(Integer.parseInt(sc.next()));
            System.out.println("type the flight code");
            flight.setCode(sc.next());
            flight.setAircraft(Main.aircraftList.get(1));
            flight.setFlightStatus(Main.flightStatusList.get(1));

            Main.flightServices.add(flight, Main.flightList);

            System.out.println("Flight added successfully");



        }catch (Exception e){
            System.out.println("Error adding flight: "+ e.getMessage());
        }

    }


    public static void printFlight() {

        try {

            Main.flightServices.printElements(Main.flightList);
        }catch (Exception e){
            System.out.println("Error printing flight"+ e.getMessage());
        }

    }
}
