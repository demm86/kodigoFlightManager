package projectSolid.Implementation;

import projectSolid.Entities.City;
import projectSolid.Entities.Country;
import projectSolid.Interfaces.ICityServices;

import java.util.ArrayList;
import java.util.List;

public class CityServices implements ICityServices {

    @Override
    public  List<City> setElements(List<Country> list) {
        List<City> cities = new ArrayList<>();

        cities.add(new City(1, "SAL", "San Salvador", list.get(0) ));

        cities.add(new City(2, "LAX", "Los Angeles",list.get(1)));
        cities.add(new City(3, "MIA", "Miami", list.get(1)));

        cities.add(new City(4, "MDR", "Madrid", list.get(5)));
        cities.add(new City(5, "PRS", "Paris", list.get(6)));

        cities.add(new City(6, "TKY", "Tokyo" , list.get(10)));
        cities.add(new City(7, "PKN", "Pekín", list.get(12)));

        return cities;

    }

    @Override
    public List<City> elementsByCountry(int idCountry,List<City> list) {
        List<City> citiesByCountry = new ArrayList<>();
        for(City city: list){
            if(city.getCountry().getId() == idCountry){
                citiesByCountry.add(city);
            }
        }
        return citiesByCountry;
    }

    @Override
    public void printElements(List<City> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("CITY LIST\n");
        sb.append("-----------------------------------\n");
        for (City city : list){
            sb.append("ID: ").append(city.getId()).append(" |");
            sb.append("CODE: ").append(city.getCode()).append(" |");
            sb.append("NAME: ").append(city.getName()).append(" |");
            sb.append("COUNTRY").append(city.getCountry().getName()).append("\n");
        }
        System.out.println(sb);
    }
}
