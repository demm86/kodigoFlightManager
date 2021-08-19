package projectSolid.Service;

import java.util.Scanner;

import static projectSolid.Main.sb;
import static projectSolid.Service.MenuAcciones.getinfoFlight;
import static projectSolid.Service.MenuAcciones.printFlight;
import static projectSolid.Service.MenuAcciones.sendEmail;

public class Menu {
    public static void main() {
        int option=0;
        Scanner sc = new Scanner(System.in);

        while (option!=3){
            sb.setLength(0);
            sb.append("-----------------------------------------\n");
            sb.append("FLIGHTS MANAGER\n");
            sb.append("Select an option\n");
            sb.append("1. Add flight\n");
            sb.append("2. Flights list\n");
            sb.append("3. Update flights\n");
            sb.append("4. Exit\n");
            sb.append("5. Send Email\n");
            sb.append("------------------------------------------");
            System.out.println(sb);

            option  = Integer.parseInt(sc.next());

            switch (option){

                case 1:
                    getinfoFlight();
                    break;
                case 2:
                    printFlight();
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("Bye-bye");
                    System.exit(0);
                    break;
                case 5:
                    sendEmail();
            }

        }
    }


}
