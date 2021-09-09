package projectSolid.Entities;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.*;


@Data
public class Flight {
    @Getter @Setter
    private int id;
    @Getter @Setter
    private String code;
    @Getter @Setter
    private Airport departureAirport;
    @Getter @Setter
    private Airport arrivalAirport;
    @Getter @Setter
    private LocalDate departureDate;
    @Getter @Setter
    private LocalTime departureTime;
    @Getter @Setter
    private LocalDate arrivalDate;
    @Getter @Setter
    private LocalTime arrivalTime;
    @Getter @Setter
    private LocalDate delayDepartureDate;
    @Getter @Setter
    private LocalTime delayDepartureTime;
    @Getter @Setter
    private LocalDate delayArrivalDate;
    @Getter @Setter
    private LocalTime delayArrivalTime;
    @Getter @Setter
    private Airport delayArrivalAirport;
    @Getter @Setter
    private Aircraft aircraft;
    @Getter @Setter
    private FlightStatus flightStatus;

    public Flight(){}
}
