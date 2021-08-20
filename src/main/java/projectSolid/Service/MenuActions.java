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
import static projectSolid.Main.sb;

public class MenuActions {

    public static void getFlightInfo() {

        Flight flight;
        Scanner scanner = new Scanner(System.in);
        try {
            flight = new Flight();
            System.out.println("Type the flight id");
            flight.setId(Integer.parseInt(scanner.next()));
            System.out.println("Type the flight code");
            flight.setCode(scanner.next());
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

    public static void updateFlight() {
        Scanner scanner = new Scanner(System.in);
        int option=0;



        while (option!=2){
            sb.setLength(0);
            sb.append("-----------------------------------------\n");
            sb.append("Select an option to update: \n");
            sb.append("1. Update Status\n");
            sb.append("2. Update Time\n");
            sb.append("3. Return main\n");
            sb.append("------------------------------------------");
            System.out.println(sb);

            option = Integer.parseInt(scanner.next());

            switch (option){
                case 1:
                    System.out.println("Update status");
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
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        //properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.user", data.getSender());
        properties.put("mail.smtp.password", data.getPassword());

        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);

        try {
            int id;
            int idVuelo;
            String code;
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
                    status = f.getFlightStatus().getName();
                    message.setSubject("Esto es una prueba");
                    message.setText("Datos de vuelo: \n" +
                            "ID Flight: " + idVuelo + "\n" +
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
