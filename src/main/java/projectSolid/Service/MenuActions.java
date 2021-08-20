package projectSolid.Service;

import projectSolid.Entities.Airport;
import projectSolid.Entities.Flight;
import projectSolid.Entities.FlightStatus;
import projectSolid.Implementation.FlightServices;
import projectSolid.Main;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import static projectSolid.Main.sb;

public class MenuActions {

    public static void getFlightInfo() {

        Flight flight;
        //Airport airport;
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        try {

            flight = new Flight();
            Airport airport1 = new Airport();
            System.out.println("Type the flight id");
            flight.setId(Integer.parseInt(scanner.next()));
            System.out.println("Type the flight code");
            flight.setCode(scanner.next());

            System.out.println("Type the departure airport");
            airport1.setName(scanner.next());
            flight.setDepartureAirport(airport1);

            Airport airport2 = new Airport();
            System.out.println("Type departure date");
            flight.setDepartureTime(LocalDateTime.parse(scanner.next()));

            System.out.println("Type the arrival airport");
            airport2.setName(scanner.next());
            flight.setArrivalAirport(airport2);

            System.out.println("Type arrival date");
            flight.setArrivalTime(LocalDateTime.parse(scanner.next()));


            flight.setAircraft(Main.aircraftList.get(1));
            flight.setFlightStatus(Main.flightStatusList.get(1));

            Main.flightServices.add(flight, Main.flightList);

            System.out.println("Flight added successfully");

        }catch (Exception e){
            System.out.println("Error adding flight: "+ e.getMessage());
        }

    }


    public static void printFlight() {

        try {

            Main.flightServices.printElements(Main.flightList);
        }catch (Exception e){
            System.out.println("Error printing flight"+ e.getMessage());
        }

    }

    public static void flightValidation() throws GeneralSecurityException, IOException {
        Scanner scanner = new Scanner(System.in);

        int flightId;
        Flight flightToUpdate;

        System.out.println("Type the flight id");
        flightId = Integer.parseInt(scanner.next());
        try{
            flightToUpdate= Main.flightServices.searchFlightById(flightId,Main.flightList).get(0);
            System.out.println(flightToUpdate);
            updateFlightMenu(flightToUpdate,Main.flightList);
        }
        catch(Exception e){
            System.out.println("That flight does not exist!");
            Menu.main();
        }

    }

    public static void getNewFlightStatus(Flight flightToUpdate, List<Flight> flightList) {
        Scanner scanner = new Scanner(System.in);

        int idNewFlightStatus;
        FlightStatus newFlightStatus;
        Main.flightStatusServices.printElements(Main.flightStatusList);
        System.out.println("Enter the number of the new flight status");
        idNewFlightStatus=Integer.parseInt(scanner.next());

        newFlightStatus=Main.flightStatusList.get(idNewFlightStatus-1);

        updateFlightStatus(newFlightStatus, flightToUpdate,flightList );

    }

    public static void updateFlightStatus(FlightStatus status, Flight flightToUpdate, List<Flight> flightList) {
        Main.flightServices.changeStatus(status,flightToUpdate,flightList);
        System.out.println("Flight status updated successfully!");
    }

    public static void updateFlightMenu(Flight flightToUpdate, List<Flight> flightList) throws GeneralSecurityException, IOException {
        Scanner scanner = new Scanner(System.in);
        int option=0;



        while (option!=2){
            sb.setLength(0);
            sb.append("-----------------------------------------\n");
            sb.append("Select an option to update: \n");
            sb.append("1. Update Status\n");
            sb.append("2. Update Departure Time\n");
            sb.append("3. Return main\n");
            sb.append("------------------------------------------");
            System.out.println(sb);

            option = Integer.parseInt(scanner.next());

            switch (option){
                case 1:
                    System.out.println("Update Flight status");
                    getNewFlightStatus(flightToUpdate,flightList);
                    break;
                case 2:
                    System.out.println("Update time");
                    break;
                case 3:
                    Menu.main();
                    break;

            }
        }
    }

    public static void sendEmail() {
        EmailData data = new EmailData();

        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.user", data.getSender());
        properties.put("mail.smtp.password", data.getPassword());

        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);

        try {
            int id;
            int idVuelo;
            String code;
            String DepAirport;
            String ArrAriport;
            String status;
            Scanner sc = new Scanner(System.in);
            message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(data.getReceiver())));
            printFlight();
            System.out.println("type the iD Flight");
            id = Integer.parseInt(sc.next());
            for (Flight f : Main.flightList) {
                if (id == f.getId()) {
                    idVuelo = f.getId();
                    code = f.getCode();
                    DepAirport = f.getDepartureAirport().getName();
                    ArrAriport = f.getArrivalAirport().getName();
                    status = f.getFlightStatus().getName();
                    message.setSubject("Esto es una prueba");
                    message.setText("Datos de vuelo: \n" +
                            "ID Flight: " + idVuelo + "\n" +
                            "Departure Airport: "+ DepAirport +"\n"+
                            "Arrival Airport: "+ ArrAriport +"\n"+
                            "Code: " + code + "\n" +
                            "Status: " + status);
                    Transport transport = session.getTransport("smtp");
                    transport.connect("smtp.gmail.com", data.getSender(), data.getPassword());
                    transport.sendMessage(message, message.getAllRecipients());
                    transport.close();
                    System.out.println("Email sent");
                }
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
