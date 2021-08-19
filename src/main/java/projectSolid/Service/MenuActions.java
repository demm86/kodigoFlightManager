package projectSolid.Service;

import projectSolid.Entities.Flight;
import projectSolid.Implementation.FlightServices;
import projectSolid.Main;

import java.util.Scanner;
import static projectSolid.Main.sb;

public class MenuActions {

    public static void getFlightInfo() {

        Flight flight;
        Scanner scanner = new Scanner(System.in);
        try {
            flight = new Flight();
            System.out.println("Type the flight id");
            flight.setId(Integer.parseInt(scanner.next()));
            System.out.println("Type the flight code");
            flight.setCode(scanner.next());
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

    public static void updateFlight() {
        Scanner scanner = new Scanner(System.in);
        int option=0;



        while (option!=2){
            sb.setLength(0);
            sb.append("-----------------------------------------\n");
            sb.append("Select an option to update: \n");
            sb.append("1. Update Status\n");
            sb.append("2. Update Time\n");
            sb.append("3. Return main\n");
            sb.append("------------------------------------------");
            System.out.println(sb);

            option = Integer.parseInt(scanner.next());

            switch (option){
                case 1:
                    System.out.println("Update status");
                    break;
                case 2:
                    System.out.println("Update time");
                    break;
                case 3:
                    Menu.main();
                    break;

            }
        }
    }
}
