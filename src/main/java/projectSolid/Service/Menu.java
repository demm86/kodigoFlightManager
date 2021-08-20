package projectSolid.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Scanner;
import static projectSolid.Service.MenuActions.*;

public class Menu {
    public static void main() throws GeneralSecurityException, IOException {
        StringBuilder sb = new StringBuilder();
        Sheet sheet = new Sheet();
        int option=0;
        Scanner scanner = new Scanner(System.in);

        while (option!=3){
            sb.setLength(0);
            sb.append("-----------------------------------------\n");
            sb.append("FLIGHTS MANAGER\n");
            sb.append("Select an option\n");
            sb.append("1. Add flight\n");
            sb.append("2. Flights list\n");
            sb.append("3. Update flights\n");
            sb.append("4. Send Email\n");
            sb.append("5. Generate excel\n");
            sb.append("6. Exit\n");
            sb.append("------------------------------------------\n");
            System.out.println(sb);

            option  = Integer.parseInt(scanner.next());

            switch (option){

                case 1:
                    getFlightInfo();
                    break;
                case 2:
                    printFlight();
                    break;
                case 3:
                    flightValidation();
                    break;
                case 4:
                    sendEmail();
                    break;
                case 5:
                    sheet.createSheet();
                    break;
                case 6:
                    System.out.println("Bye-bye");
                    System.exit(0);
                    break;
            }

        }
    }


}
