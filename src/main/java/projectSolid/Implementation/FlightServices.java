package projectSolid.Implementation;

import projectSolid.Entities.Airport;
import projectSolid.Entities.City;
import projectSolid.Entities.Flight;
import projectSolid.Entities.FlightStatus;
import projectSolid.Interfaces.IEmail;
import projectSolid.Interfaces.IFlightServices;

import java.util.ArrayList;
import java.util.List;

public class FlightServices implements IFlightServices, IEmail {
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
        System.out.println("Flight list:"+list);
    }

    @Override
    public List<Flight> add(Flight fight, List<Flight> list) {
        list.add(fight);
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
