package projectSolid.Service;

import projectSolid.Entities.*;
import projectSolid.Implementation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuActions {

    Scanner scanner = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    CountryServices countryServices = new CountryServices();
    List<Country> countries;

    CityServices cityServices = new CityServices();
    List<City> cities;

    AircraftTypesServices aircraftTypesServices = new AircraftTypesServices();
    List<AircraftType> aircraftTypes;

    FlightStatusServices flightStatusServices = new FlightStatusServices();
    List<FlightStatus> flightStatuses;

    AirlineServices airlineServices = new AirlineServices();
    List<Airline> airlines;

    AirportServices airportServices = new AirportServices();
    List<Airport> airports;

    AircraftServices aircraftServices = new AircraftServices();
    List<Aircraft> aircrafts;

    Flight flight;
    FlightServices flightServices = new FlightServices();

    List<Flight> flights = new ArrayList<>();

    public void showFlights(){
        flightServices.printElements(flights);
    }

    public void addFlight(){
        flight = new Flight();

        countries = countryServices.setElements();
        cities = cityServices.setElements(countries);
        aircraftTypes = aircraftTypesServices.setAircraftType();
        flightStatuses = flightStatusServices.setElements();
        airlines = airlineServices.setAirline(countries);
        airports = airportServices.setAirport(cities);
        aircrafts = aircraftServices.setElements(airlines,aircraftTypes);

        sb.setLength(0);
        sb.append("Type flight information\n");
        sb.append("----------------------------------------------\n");
        System.out.println(sb);

        System.out.println("Type flight id: ");

        flight.setId(Integer.parseInt(scanner.next()));

        System.out.println("Type flight code: ");
        flight.setCode(scanner.next());

        airportServices.printElements(airports);
        System.out.println("Departure Airport: ");
        flight.setDepartureAirport(airportServices.getAirport(Integer.parseInt(scanner.next()), airports));

        System.out.println("Arrival Airport: ");
        flight.setArrivalAirport(airportServices.getAirport(Integer.parseInt(scanner.next()), airports));

        System.out.println("Departure time: (Type format as the example: 2021-12-31T00:00)");
        flight.setDepartureTime(LocalDateTime.parse(scanner.next()));

        System.out.println("Arrival time: (Type format as the example: 2021-12-31T00:00)");
        flight.setArrivalTime(LocalDateTime.parse(scanner.next()));

        aircraftServices.printElements(aircrafts);
        System.out.println("Assign aircraft to flight: ");
        flight.setAircraft(aircraftServices.getAircraft(Integer.parseInt(scanner.next()), aircrafts));

        flight.setFlightStatus(flightStatusServices.getFlightStatus(1, flightStatuses));

        flightServices.add(flight, flights);

        System.out.println("Flight added successfully");
    }

    public void updateFlight(){
        System.out.println("Select flight to updated");
        flightServices.printElements(flights);
        Flight selectedFlight = flightServices.searchFlightById(Integer.parseInt(scanner.next()), flights);
        flightServices.printFlight(selectedFlight);

        System.out.println("Select new status: ");
        flightStatuses = flightStatusServices.setElements();
        flightStatusServices.printElements(flightStatuses);

        int status = Integer.parseInt(scanner.next());
        if(status == 2 || status == 4){
            FlightStatus selectedFlightStatus =  flightStatusServices.getFlightStatus(status, flightStatuses);
            flightServices.changeStatus(selectedFlightStatus, selectedFlight, flights);
            System.out.println("Status updated successfully");
        }else if(status == 3){
            StringBuilder sb = new StringBuilder();
            sb.append("What is delayed? Departure or Arrival time: \n");
            sb.append("1. Departure time\n").append("2. Arrival time\n");
            System.out.println(sb);
            int selectedOption = Integer.parseInt(scanner.next());
            switch(selectedOption){
                case 1:
                    System.out.println("Departure time updated successfully");
                    break;
                case 2:
                    System.out.println("Arrival time updated successfully");
                    break;
                default:
                    System.out.println("Option incorrect");
                    break;
            }
        }else{
            System.out.println("Status incorrect");
        }
    }

    public void searchFlight(){
        countries = countryServices.setElements();
        cities = cityServices.setElements(countries);
        airports = airportServices.setAirport(cities);

        int id;
        boolean flag = true;

        Airport airport;

        int selectedOption = 0;
        while(selectedOption < 4){
            sb.setLength(0);
            sb.append("Search flight by: \n");
            sb.append("1. Status\n");
            sb.append("2. Departure airport\n");
            sb.append("3. Arrival airport\n");
            sb.append("4. Main menu\n");
            System.out.println(sb);
            selectedOption = Integer.parseInt(scanner.next());
            switch(selectedOption){
                case 1:
                    System.out.println("Select status: \n");
                    flightStatuses = flightStatusServices.setElements();
                    flightStatusServices.printElements(flightStatuses);
                    do {
                        id = Integer.parseInt(scanner.next());
                        if(id < 0 || id > flightStatuses.size()){
                            System.out.println("Option incorrect. Please enter the correct number: ");
                        }else{
                            flag = false;
                        }
                    }while(flag);
                    FlightStatus flightStatus = flightStatusServices.getFlightStatus(id, flightStatuses);

                    List<Flight> flightsByStatus = flightServices.listByStatus(flightStatus, flights);

                    flightServices.printElements(flightsByStatus);
                    break;
                case 2:
                    System.out.println("Select departure Airport: \n");
                    airportServices.printElements(airports);
                    do {
                        id = Integer.parseInt(scanner.next());
                        if(id < 0 || id > airports.size()){
                            System.out.println("Option incorrect. Please enter the correct number: ");
                        }else{
                            flag = false;
                        }
                    }while(flag);
                    airport = airportServices.getAirport(id, airports);

                    List<Flight> flightsByDepartureAirport = flightServices.listByDepartureAirport(airport, flights);

                    flightServices.printElements(flightsByDepartureAirport);
                    break;
                case 3:
                    System.out.println("Select arrival Airport: \n");
                    airportServices.printElements(airports);
                    do {
                        id = Integer.parseInt(scanner.next());
                        if(id < 0 || id > airports.size()){
                            System.out.println("Option incorrect. Please enter the correct number: ");
                        }else{
                            flag = false;
                        }
                    }while(flag);
                    airport = airportServices.getAirport(id, airports);

                    List<Flight> flightsByArrivalAirport = flightServices.listByArrivalAirport(airport, flights);

                    flightServices.printElements(flightsByArrivalAirport);
                    break;
            }
        }
    }
}
