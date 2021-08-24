package projectSolid.Implementation;

import projectSolid.Entities.Aircraft;
import projectSolid.Entities.Airline;
import projectSolid.Entities.Country;
import projectSolid.Interfaces.IAirlineServices;

import java.util.ArrayList;
import java.util.List;

public class AirlineServices implements IAirlineServices {
    @Override
    public List<Airline> setAirline(List<Country> list) {
        List<Airline> airlines = new ArrayList<>();

        airlines.add(new Airline(1, "AV", "Avianca", list.get(4)));
        airlines.add(new Airline(2, "QA", "Qatar Airways", list.get(11)));
        airlines.add(new Airline(3, "TA", "Thai Airways", list.get(13)));
        airlines.add(new Airline(4, "CH", "Cathay Pacific", list.get(12)));
        airlines.add(new Airline(5, "NA", "All Nippon Airways", list.get(10)));

        return airlines;
    }

    @Override
    public void printElements(List<Airline> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("AIRLINES LIST\n");
        sb.append("---------------------------------------------\n");
        for (Airline airline: list) {
            sb.append("ID: ").append(airline.getId()).append(" |");
            sb.append("CODE: ").append(airline.getCode()).append(" |");
            sb.append("NAME: ").append(airline.getName()).append(" |");
            sb.append("COUNTRY: ").append(airline.getCountry().getName()).append("\n");
        }
        System.out.println(sb);
    }
}
