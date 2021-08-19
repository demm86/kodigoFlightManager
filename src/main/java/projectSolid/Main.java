package projectSolid;

import projectSolid.Entities.*;
import projectSolid.Implementation.CityServices;
import projectSolid.Implementation.CountryServices;
import projectSolid.Implementation.FlightServices;
import projectSolid.Implementation.FlightStatusServices;

import java.time.LocalDateTime;
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



    public static void main(String[] args) {

        Aircraft aircraft = new Aircraft();
        Flight flightTmp = new Flight();
        Airport air = new Airport();

        flightTmp.setId(1);
        flightTmp.setCode("test");
        air.setName("Juan Santamaria");
        flightTmp.setDepartureAirport(air);

        flightServices.add(flightTmp,flightList);
        flightServices.printElements(flightList);

       /* flightStatusList = flightStatusServices.setElements();
        flightStatusServices.printElements(flightStatusList);*/

        flightServices.changeStatus(flightStatusList.get(0),flightTmp,flightList);
        flightServices.printElements(flightList);



        countryList = countryServices.setElements();
        countryServices.printElements(countryList);

        cityList = cityServices.setElements(countryList);
        cityListByCountry = cityServices.elementsByCountry(2,cityList);
        cityServices.printElements(cityListByCountry);

        mainP();


    }


    public static void mainP(){

        int option=0;
        Scanner sc = new Scanner(System.in);
        sb.append("-----------------------------------------\n");
        sb.append("FLIGHTS MANAGER\n");
        sb.append("Select an option\n");
        sb.append("1. Add flight\n");
        sb.append("2. Flights list\n");
        sb.append("3. Update flights\n");
        sb.append("4. Send Email\n");
        sb.append("5. Exit\n");
        sb.append("------------------------------------------");
        while (option!=4){

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

                    sendEmail();
                    break;
                case 5:
                    System.out.println("Bye-bye");
                    System.exit(0);
                    break;
            }

        }



    }

    public static void addFlight(){

        try {
            Airport port = new Airport();
            FlightStatus fs = new FlightStatus();


            fl = new Flight();
            System.out.println("type the flight id");
            fl.setId(sc.nextInt());
            System.out.println("type the flight code");
            fl.setCode(sc.next());
            System.out.println("type the departure Airport");
            port.setName(sc.nextLine());
            fl.setDepartureAirport(port);
            System.out.println("Type the arrival airport");
            port = new Airport();
            port.setName(sc.next());
            fl.setDelayArrivalAirport(port);
            System.out.println("Type the status of the flight");
            fs.setName(sc.next());
            fl.setFlightStatus(fs);
            System.out.println("Type departure time");
            fl.setDepartureTime(LocalDateTime.parse(sc.next()));
            System.out.println("Type Arrival time");
            fl.setArrivalTime(LocalDateTime.parse(sc.next()));

            flightList.add(fl);

            System.out.println("Flight added successfully");
           // mainP();


        }catch (Exception e){
            System.out.println("Error al insertar un nuevo vuelo: "+ e.getMessage());
        }
    }

    public static void seeFlights(){


        System.out.println("Flights List:");
        System.out.println("---------------------------------");
        for (Flight f: flightList) {
            System.out.println("ID: "+f.getId()+"\n"+
                    "Code: "+f.getCode()+"\n"+
                    "Departure: "+f.getDepartureAirport()+"\n"+
                    "Arrival: "+f.getDelayArrivalAirport()+"\n"+
                    "Status: "+f.getFlightStatus()+"\n"+
                    "Departure Time: "+f.getDepartureTime()+"\n"+
                    "Arrival Time: "+ f.getArrivalTime());
            System.out.println("---------------------------------");
            System.out.println();
        }

    }

    public  static void updateFlight(){
        Scanner sc = new Scanner(System.in);
        int op;
        System.out.println("\nSelect an option\n");
        System.out.println("1. Update Status\n");
        System.out.println("2. Update Time\n");
        /*sb.append("\nSelect an option: \n");
        sb.append("1. Update Status\n");
        sb.append("2. Update Time\n");
        System.out.println(sb);*/
        op = Integer.parseInt(sc.next());
        switch (op){
            case 1:
                seeFlights();
                System.out.println("Type the id Flight");
                int seek = sc.nextInt();
                for (Flight f: flightList) {
                    if(seek == f.getId()){
                        try {
                            FlightStatus fs = f.getFlightStatus();
                            System.out.println("Type the new status");
                            fs.setName(sc.next());
                            System.out.println("Status Updated Successfully");
                        }catch (Exception e){
                            System.out.println("Error al modificar el status: "+e.getMessage());

                        }

                    }
                }
                break;
            case 2:
                seeFlights();
                System.out.println("Type the id Flight");
                int seekk = sc.nextInt();
                for (Flight f: flightList) {
                    if(seekk == f.getId()){
                        try {

                            System.out.println("Type new Departure time");
                            f.setDepartureTime(LocalDateTime.parse(sc.next()));
                            System.out.println("Type new Arrival time");
                            f.setArrivalTime(LocalDateTime.parse(sc.next()));
                        }catch (Exception e){

                        }
                    }
                }
                break;

        }

    }

    public static  void sendEmail(){

    }



}
