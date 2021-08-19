package projectSolid.Service;

import projectSolid.Entities.Flight;
import projectSolid.Implementation.FlightServices;
import projectSolid.Main;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

public class MenuAcciones {

    public static void getinfoFlight() {

        Flight flight;
        Scanner sc = new Scanner(System.in);
        try {
            flight = new Flight();
            System.out.println("type the flight id");
            flight.setId(Integer.parseInt(sc.next()));
            System.out.println("type the flight code");
            flight.setCode(sc.next());
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

    public static void sendEmail(){
        EmailData data = new EmailData();

        Properties properties = new Properties();

        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.user", data.getSender());
        properties.put("mail.smtp.password", data.getPassword());

        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);

        try {
            message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(data.getReceiver())));
            message.setSubject("Esto es una prueba");
            message.setText("Hola");
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", data.getSender(), data.getPassword());
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Email sent");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}


