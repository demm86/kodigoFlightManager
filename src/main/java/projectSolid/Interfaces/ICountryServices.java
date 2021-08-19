package projectSolid.Interfaces;

import projectSolid.Entities.City;
import projectSolid.Entities.Country;

import java.util.List;

public interface ICountryServices {

        List<Country> setCountry();
        void printElements(List<Country> list);


}
