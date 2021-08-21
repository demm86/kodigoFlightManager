package projectSolid.Implementation;

import projectSolid.Entities.Country;
import projectSolid.Interfaces.ICountryServices;

import java.util.ArrayList;
import java.util.List;

public class CountryServices  implements ICountryServices {
    @Override
    public List<Country> setElements() {
        List<Country> countries = new ArrayList<>();

        countries.add(new Country(1, "503", "El Salvador"));
        countries.add(new Country(2, "1", "United States"));
        countries.add(new Country(3, "54", "Argentina"));
        countries.add(new Country(4, "52", "Mexico"));
        countries.add(new Country(5, "56", "Chile"));

        countries.add(new Country(6, "34", "Spain"));
        countries.add(new Country(7, "33", "France"));
        countries.add(new Country(8, "39", "Italy"));
        countries.add(new Country(9, "49", "Germany"));
        countries.add(new Country(10, "374", "Armenia"));

        countries.add(new Country(11, "81", "Japan"));
        countries.add(new Country(12, "82", "South Korea"));
        countries.add(new Country(13, "86", "China"));
        countries.add(new Country(14, "66", "Thailand"));
        countries.add(new Country(15, "91", "India"));

        return countries;
    }

    @Override
    public void printElements(List<Country> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("COUNTRY LIST\n");
        sb.append("------------------------\n");
        for (Country country : list){
            sb.append("ID: ").append(country.getId()).append(" |");
            sb.append("CODE: ").append(country.getCode()).append(" |");
            sb.append("NAME: ").append(country.getName()).append("\n");
        }
        System.out.println(sb);
    }
}
