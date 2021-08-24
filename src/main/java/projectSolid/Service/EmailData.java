package projectSolid.Service;

import lombok.Getter;
import lombok.Setter;

public class EmailData {

        @Getter
        @Setter
        private String sender;
        @Getter @Setter
        private String password;
        @Getter @Setter
        private String receiver;

        public EmailData(){
            this.sender ="ismaellatin7@gmail.com";
            this.password = "Scouts72.";
            this.receiver = "bryansabillongp@gmail.com";
        }

        /*public static void sendEmail() {
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
            //printFlight();
            System.out.println("type the iD Flight");
            id = Integer.parseInt(sc.next());
            for (Flight f : flightList) {
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
    }*/
}
