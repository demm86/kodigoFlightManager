package projectSolid.Implementation;

import projectSolid.Entities.Airport;
import projectSolid.Entities.Flight;
import projectSolid.Entities.FlightStatus;
import projectSolid.Interfaces.IEmail;
import projectSolid.Interfaces.IFlightServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FlightServices implements IFlightServices, IEmail {

    @Override
    public Flight searchFlightById(int id, List<Flight> list) {

        Flight flightFound = new Flight();
        for(Flight flight: list){
            if(flight.getId() == id){
                flightFound = flight;
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
    public void printFlight(Flight flight) {
        if(!Objects.isNull(flight)){
            StringBuilder sb = new StringBuilder();
            sb.append("SELECTED FLIGHT\n");
            sb.append("-----------------------------------------------------\n");

            sb.append("ID: ").append(flight.getId()).append("\n");
            sb.append("CODE: ").append(flight.getCode()).append("\n");
            sb.append("DEPARTURE AIRPORT: ").append(flight.getDepartureAirport().getName()).append("\n");
            sb.append("DEPARTURE DATE: ").append(flight.getDepartureDate()).append("\n");
            sb.append("DEPARTURE TIME: ").append(flight.getDepartureTime()).append("\n");
            sb.append("ARRIVAL AIRPORT: ").append(flight.getArrivalAirport().getName()).append("\n");
            sb.append("ARRIVAL DATE: ").append(flight.getArrivalDate()).append("\n");
            sb.append("ARRIVAL TIME: ").append(flight.getArrivalTime()).append("\n");
            if(flight.getDelayDepartureDate() == null){
                sb.append("DELAY DEPARTURE DATE: ").append("No data").append("\n");
            }else{
                sb.append("DELAY DEPARTURE DATE: ").append(flight.getDelayDepartureDate()).append("\n");
            }
            if(flight.getDelayDepartureTime() == null){
                sb.append("DELAY DEPARTURE TIME: ").append("No data").append("\n");
            }else{
                sb.append("DELAY DEPARTURE TIME: ").append(flight.getDelayDepartureTime()).append("\n");
            }
            if(flight.getDelayArrivalDate() == null){
                sb.append("DELAY ARRIVAL DATE: ").append("No data").append("\n");
            }else{
                sb.append("DELAY ARRIVAL DATE: ").append(flight.getDelayArrivalDate()).append("\n");
            }
            if(flight.getDelayArrivalTime() == null){
                sb.append("DELAY ARRIVAL TIME: ").append("No data").append("\n");
            }else{
                sb.append("DELAY ARRIVAL TIME: ").append(flight.getDelayArrivalTime()).append("\n");
            }
            if(Objects.isNull(flight.getDelayArrivalAirport())){
                sb.append("DELAY ARRIVAL AIRPORT: ").append("No data").append("\n");
            }else{
                sb.append("DELAY ARRIVAL AIRPORT: ").append(flight.getDelayArrivalAirport().getName()).append("\n");
            }
            sb.append("AIRCRAFT: ").append(flight.getAircraft().getModel()).append("\n");
            sb.append("FLIGHT STATUS: ").append(flight.getFlightStatus().getName()).append("\n");

            System.out.println(sb);
        }else{
            System.out.println("Flight not exist\n");
        }

    }

    @Override
    public void printElements(List<Flight> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("FLIGHTS LIST\n");
        sb.append("-------------------------------------------------\n");
        for (Flight flight: list) {
            sb.append("ID: ").append(flight.getId()).append(" |");
            sb.append("CODE: ").append(flight.getCode()).append(" |");
            sb.append("DEPARTURE: ").append(flight.getDepartureAirport().getCode()).append(" |");
            sb.append("ARRIVAL: ").append(flight.getArrivalAirport().getCode()).append(" |");
            sb.append("FLIGHT STATUS: ").append(flight.getFlightStatus().getName()).append("\n");
        }
        System.out.println(sb);
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
        Flight flightTmp;

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
