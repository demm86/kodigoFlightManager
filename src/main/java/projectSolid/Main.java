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

        sheet.test();
        sb.setLength(0);
        Aircraft aircraft = new Aircraft();
        Flight flightTmp = new Flight();

        flightTmp.setId(1);
        flightTmp.setCode("test");

        flightServices.add(flightTmp,flightList);
        flightServices.printElements(flightList);

        flightStatusList = flightStatusServices.setElements();
        flightStatusServices.printElements(flightStatusList);

        flightServices.changeStatus(flightStatusList.get(0),flightTmp,flightList);
        flightServices.printElements(flightList);



        countryList = countryServices.setElements();
        countryServices.printElements(countryList);

        cityList = cityServices.setElements(countryList);
        cityListByCountry = cityServices.elementsByCountry(2,cityList);
        cityServices.printElements(cityListByCountry);


    }


    public static void mainP(){

        int option=0;
        Scanner sc = new Scanner(System.in);
        while (option!=3){
            sb.append("-----------------------------------------\n");
            sb.append("FLIGHTS MANAGER\n");
            sb.append("Select an option\n");
            sb.append("1. Add flight\n");
            sb.append("2. Flights list\n");
            sb.append("3. Update flights\n");
            sb.append("4. Exit\n");
            sb.append("------------------------------------------");
            System.out.println(sb);

            option  = Integer.parseInt(sc.next());

            switch (option){

                case 1:
                    addFlight();
                    break;
                case 2:
                    seeFlights();

                    break;
                case 3:
                    updateFlight();
                    break;
                case 4:
                    System.out.println("Bye-bye");
                    System.exit(0);
                    break;
            }

        }



    }

    public static void addFlight(){

        try {
            fl = new Flight();
            System.out.println("type the flight id");
            fl.setId(Integer.parseInt(sc.next()));
            System.out.println("type the flight code");
            fl.setCode(sc.nextLine());
            System.out.println("type the departure city");
           // fl.setDepartureAirport((Airport));
            System.out.println("Type the arrival city");
           // fl.setArrivalCity(sc.nextLine());
            System.out.println("Type the status of the flight");
            //fl.setStatus(sc.nextLine());
            flightList.add(fl);

            System.out.println("Flight added successfully");
            mainP();


        }catch (Exception e){
            System.out.println("Error al insertar un nuevo vuelo: "+ e.getMessage());
        }
    }

    public static void seeFlights(){
        /*
        fl.setIdFlight(1);
        fl.setCode("A2W3k1");
        fl.setDepartureCity("Los Angeles");
        fl.setArrivalCity("San Salvador");
        fl.setStatus("On Time");
        flightList.add(fl);
        System.out.println("LISTA DE VUELOS:");
        System.out.println("---------------------------------");
        for (Flight f: flightList) {
            System.out.println("ID: "+f.getIdFlight()+"\n"+
                    "Code: "+f.getCode()+"\n"+
                    "Departure: "+f.getDepartureCity()+"\n"+
                    "Arrival: "+f.getArrivalCity()+"\n"+
                    "Status: "+f.getStatus());
            System.out.println("---------------------------------");
            System.out.println();
        }
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
                mainP();
                break;

        }

    }



}
