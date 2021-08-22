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

    Flight flight = new Flight();
    FlightServices flightServices = new FlightServices();
    List<Flight> flights = new ArrayList<>();

    public void showFlights(){
        flightServices.printElements(flights);
    }

    public void addFlight(){
        countries = countryServices.setElements();
        cities = cityServices.setElements(countries);
        aircraftTypes = aircraftTypesServices.setAircraftType();
        flightStatuses = flightStatusServices.setElements();
        airlines = airlineServices.setAirline(countries);
        airports = airportServices.setAirport(cities);
        aircrafts = aircraftServices.setElements(airlines,aircraftTypes);

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

        flight.setFlightStatus(flightStatusServices.getFlightStatus(2, flightStatuses));

        flightServices.add(flight, flights);

        System.out.println("Flight added successfully");
    }

    public void updateFlight(){}
}
