package projectSolid.Implementation;

import projectSolid.Entities.Airport;
import projectSolid.Entities.City;
import projectSolid.Entities.Flight;
import projectSolid.Entities.FlightStatus;
import projectSolid.Interfaces.IEmail;
import projectSolid.Interfaces.IFlightServices;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FlightServices implements IFlightServices, IEmail {

    public boolean flightExists= false;

    @Override
    public List<Flight> searchFlightById(int id, List<Flight> list) {
        List<Flight> flightFound = new ArrayList<>();
        for(Flight flight: list){
            if(flight.getId() == id){
                flightFound.add(flight);
                flightExists=true;
            }
        }
        return flightFound;
    }

    @Override
    public List<Flight> listByStatus(FlightStatus status ,List<Flight> list) {

        List<Flight> flightByStatus = new ArrayList<>();
        for(Flight flight: list){
            if(flight.getFlightStatus().getId() == status.getId()){
                flightByStatus.add(flight);
            }
        }
        return flightByStatus;

    }

    @Override
    public List<Flight>  listByDepartureAirport(Airport airport,List<Flight> list) {

        List<Flight> flightByDeparture= new ArrayList<>();
        for(Flight flight: list){
            if(flight.getDepartureAirport().getId() == airport.getId()){
                flightByDeparture.add(flight);
            }
        }
        return flightByDeparture;

    }

    @Override
    public List<Flight> listByArrivalAirport(Airport airport,List<Flight> list) {
        List<Flight> flightByArrival= new ArrayList<>();
        for(Flight flight: list){
            if(flight.getArrivalAirport().getId() == airport.getId()){
                flightByArrival.add(flight);
            }
        }
        return flightByArrival;

    }

    @Override
    public void printElements(List<Flight> list) {

        System.out.println("Flight List:");
        System.out.println("---------------------------------");
        for (Flight flight: list) {
            System.out.println("ID: " + flight.getId() + "\n" +
                    "Code: " + flight.getCode() + "\n" +
                    "Departure: " + flight.getArrivalAirport() + "\n" +
                    "Arrival: " + flight.getArrivalAirport() + "\n" +
                    "Status: " + flight.getFlightStatus().getName()+ "\n" +
                    "Aircraft: " + flight.getAircraft().getModel()+ "\n" +
                    "Departure time: "+flight.getDepartureTime()+"\n" +
                    "Arrival time: "+flight.getArrivalTime());
            System.out.println("---------------------------------");
            System.out.println();

        }
    }

    @Override
    public List<Flight> add(Flight flight, List<Flight> list) {

        int indexTmp;
        indexTmp = list.indexOf(flight);

        if( indexTmp == -1) {
            list.add(flight);
        }


        return list ;
    }

    @Override
    public List<Flight> changeStatus(FlightStatus status,Flight flight, List<Flight> list) {
        Flight flightTmp = new Flight();

        int indexTmp;
        indexTmp = list.indexOf(flight);

        if( indexTmp!= -1) {
            flightTmp = list.get(indexTmp);
            flightTmp.setFlightStatus(status);
            list.set(indexTmp,flightTmp);
        }

        return list;
    }

    @Override
    public void sendEmailFlightDetails(String email, Flight flight) {

    }

    @Override
    public void sendEmailFlightChange(String email, Flight flight) {

    }
}
