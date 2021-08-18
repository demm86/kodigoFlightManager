package projectSolid;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Flight {
    private int id;
    private String code;
    private Aircraft aircraft;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private LocalDateTime delayDepartureTime;
    private LocalDateTime delayArrivalTime;
    private Airport delayArrivalAirport;
    private FlightStatus flightStatus;
}
