package projectSolid;

import projectSolid.Entities.*;
import projectSolid.Implementation.*;
import projectSolid.Service.Menu;
import projectSolid.Service.Sheet;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static StringBuilder sb = new StringBuilder();
    public static Flight fl;
    public static List<Flight> flightList = new ArrayList<>();
    public static City city = new City();
    public static List<City> cityList = new ArrayList<>();
    public static List<City> cityListByCountry = new ArrayList<>();
    public static CityServices cityServices = new  CityServices();

    public static List<Country> countryList = new ArrayList<>();
    public static CountryServices countryServices = new  CountryServices();


    public static FlightServices flightServices = new  FlightServices();
    public static FlightStatusServices flightStatusServices = new  FlightStatusServices();


    public static List<FlightStatus> flightStatusList = new ArrayList<>();

    public static Sheet sheet = new Sheet();


    public static AircraftServices aircraftServices = new AircraftServices();
    public static List<Aircraft> aircraftList = new ArrayList<>();



    public static void main(String[] args) throws GeneralSecurityException, IOException {

        //sheet.test();
        sb.setLength(0);
        Aircraft aircraft = new Aircraft();
        Flight flightTmp = new Flight();

        aircraftList = aircraftServices.setElements();
        aircraftServices.printElements(aircraftList);

        flightStatusList = flightStatusServices.setElements();
        flightStatusServices.printElements(flightStatusList);

        flightTmp.setId(1);
        flightTmp.setCode("test");
        flightTmp.setAircraft(aircraftList.get(1));
        flightTmp.setFlightStatus(flightStatusList.get(1));


        flightServices.add(flightTmp,flightList);
        flightServices.printElements(flightList);

        Menu.main();



        /*


        flightServices.changeStatus(flightStatusList.get(0),flightTmp,flightList);
        flightServices.printElements(flightList);



        countryList = countryServices.setElements();
        countryServices.printElements(countryList);

        cityList = cityServices.setElements(countryList);
        cityListByCountry = cityServices.elementsByCountry(2,cityList);
        cityServices.printElements(cityListByCountry);
*/

    }







    public  static void updateFlight(){
        //clean();
        Scanner sc = new Scanner(System.in);
        int op;
        sb.append("Select an option: \n");
        sb.append("1. Update Status\n");
        sb.append("2. Update Time\n");
        sb.append("3. Return main");
        System.out.println(sb);
        op = Integer.parseInt(sc.next());
        switch (op){
            case 1:
                break;
            case 2:
                break;
            case 3:
                //mainP();
                break;

        }

    }



}
