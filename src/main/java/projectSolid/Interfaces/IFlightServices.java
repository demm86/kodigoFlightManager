package projectSolid.Interfaces;

import projectSolid.Entities.Airport;
import projectSolid.Entities.Flight;
import projectSolid.Entities.FlightStatus;

import java.util.List;

public interface IFlightServices {

     Flight searchFlightById(int id,List<Flight> list);
     List<Flight> listByStatus(FlightStatus status,List<Flight> list);
     List<Flight> listByDepartureAirport(Airport airport,List<Flight> list);
     List<Flight> listByArrivalAirport(Airport airport,List<Flight> list);
     void printFlight(Flight flight);
     void printElements(List<Flight> list);
     List<Flight> add(Flight fight,List<Flight> list);
     List<Flight> changeStatus(FlightStatus status,Flight flight, List<Flight> list);

}
