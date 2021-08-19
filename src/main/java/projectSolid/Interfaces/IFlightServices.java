package projectSolid.Interfaces;

import projectSolid.Entities.Airport;
import projectSolid.Entities.Flight;
import projectSolid.Entities.FlightStatus;

import java.util.List;

public interface IFlightServices {

     List<Flight> flightsByStatus(FlightStatus status,List<Flight> list);
     List<Flight> flightsByDepartureAirport(Airport airport,List<Flight> list);
     List<Flight> flightsByArrivalAirport(Airport airport,List<Flight> list);
     void printFlight(List<Flight> list);
     List<Flight> addFlight(Flight fight,List<Flight> list);
     List<Flight> changeStatusFlight(FlightStatus status,Flight flight, List<Flight> list);

}
