package projectSolid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Flight fl;
    public static List<Flight> flightList = new ArrayList<Flight>();
    public static void main(String[] args) {

        //Aircraft aircraft = new Aircraft();
    }


    public static void mainP(){

        int opcion=0;
        Scanner sc = new Scanner(System.in);
        while (opcion!=3){
            System.out.println("---------------------------------");
            System.out.println("FLIGHTS MANAGER\n"+
                    "Select an option\n"+
                    "1. Add Flight\n"+
                    "2. Flights list\n"+
                    "3. Update flight\n"+
                    "4. Exit");
            System.out.println("---------------------------------");

            opcion  = Integer.parseInt(sc.next());

            switch (opcion){

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

        public static void addFlight(){

            try {
                fl = new Flight();
                System.out.println("type the flight id");
                fl.setId(Integer.parseInt(sc.next()));
                System.out.println("type the flight code");
                fl.setCode(sc.nextLine());
                System.out.println("type the departure city");
                fl.setDepartureAirport((Airport));
                System.out.println("Type the arrival city");
                fl.setArrivalCity(sc.nextLine());
                System.out.println("Type the status of the flight");
                fl.setStatus(sc.nextLine());
                flightList.add(fl);

                System.out.println("Flight added successfully");
                mainP();


            }catch (Exception e){
                System.out.println("Error al insertar un nuevo vuelo: "+ e.getMessage());
            }
        }

    }
}
