package projectSolid.Entities;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Data
public class Flight {
    @Getter @Setter
    private int id;
    @Getter @Setter
    private String code;
    @Getter @Setter
    private Aircraft aircraft;
    @Getter @Setter
    private Airport departureAirport;
    @Getter @Setter
    private Airport arrivalAirport;
    @Getter @Setter
    private LocalDateTime departureTime;
    @Getter @Setter
    private LocalDateTime arrivalTime;
    @Getter @Setter
    private LocalDateTime delayDepartureTime;
    @Getter @Setter
    private LocalDateTime delayArrivalTime;
    @Getter @Setter
    private Airport delayArrivalAirport;
    @Getter @Setter
    private FlightStatus flightStatus;

    @Override
    public String toString() {
        return "Flight{" +
                ", departureAirport=" + departureAirport +
                '}';
    }
}
