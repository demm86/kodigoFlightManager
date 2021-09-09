package projectSolid.Implementation;

import projectSolid.Entities.Airline;
import projectSolid.Entities.Airport;
import projectSolid.Entities.City;
import projectSolid.Interfaces.IAirportServices;
import projectSolid.Service.Weather.OpenWeatherClient;
import projectSolid.Service.Weather.WeatherForecastResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirportServices implements IAirportServices {
    public static OpenWeatherClient openWeatherClient = new OpenWeatherClient();

    @Override
    public List<Airport> setAirport(List<City> list) {
        List<Airport> airports = new ArrayList<>();

        airports.add(new Airport(1, "SAL", "El Salvador International Airport", list.get(0)));

        airports.add(new Airport(2, "LAX", "Los Ángeles International Airport", list.get(1)));
        airports.add(new Airport(3, "MIA", "Miami International Airport", list.get(2)));

        airports.add(new Airport(4, "MAD" , "Madrid-Barajas Adolfo Suárez International Airport", list.get(3)));
        airports.add(new Airport(5, "CDG", "París-Charles de Gaulle Airport", list.get(4)));

        airports.add(new Airport(6, "HDN", "Tokyo International Airport", list.get(5)));
        airports.add(new Airport(7, "PEK", "Pekín International Airport", list.get(6)));

        return airports;
    }

    @Override
    public Airport getAirport(int idAirport, List<Airport> list) {
        Airport airport = new Airport();
        for(Airport a : list){
            if(a.getId() == idAirport){
                airport = a;
            }
        }
        return airport;
    }

    @Override
    public void printElements(List<Airport> list) {
        
        StringBuilder sb = new StringBuilder();
        WeatherForecastResponse wf = new WeatherForecastResponse();

        try {

            sb.append("AIRPORT LIST\n");
            sb.append("-----------------------------------------------\n");

            for (Airport airport: list) {
                wf = openWeatherClient.forecastWeatherAtCity(airport.getCity().getName());
                sb.append("ID: ").append(airport.getId()).append(" |");
                sb.append("CODE: ").append(airport.getCode()).append(" |");
                sb.append("NAME: ").append(airport.getName()).append(" |");
                sb.append("CITY: ").append(airport.getCity().getName()).append("\n");
                sb.append(wf.stringElements());
            }



        } catch (IOException e) {
            System.out.println("error: "+ e.toString());
            e.printStackTrace();

        }


        System.out.println(sb);


    }
}
