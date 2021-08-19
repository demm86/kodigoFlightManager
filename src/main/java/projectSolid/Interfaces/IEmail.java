package projectSolid.Interfaces;

import projectSolid.Entities.Airport;
import projectSolid.Entities.Flight;
import projectSolid.Entities.FlightStatus;

import java.util.List;

public interface IEmail {

    void sendEmailFlightDetails(String email, Flight flight);
    void sendEmailFlightChange(String email, Flight flight);

}

