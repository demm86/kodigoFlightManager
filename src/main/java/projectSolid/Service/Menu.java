package projectSolid.Service;

import java.util.Scanner;

public class Menu {


    public void shoMenu() {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        MenuActions menuActions = new MenuActions();

        int option=0;

        while (option!=7){
            sb.setLength(0);
            sb.append("-----------------------------------------\n");
            sb.append("FLIGHTS MANAGER\n");
            sb.append("Select an option\n");
            sb.append("1. Add flight\n");
            sb.append("2. Flights list\n");
            sb.append("3. Update flights\n");
            sb.append("4. Search flight\n");
            sb.append("5. Send Email\n");
            sb.append("6. Generate excel\n");
            sb.append("7. Exit\n");
            sb.append("------------------------------------------\n");
            System.out.println(sb);

            option  = Integer.parseInt(scanner.next());

            switch (option){

                case 1:
                    menuActions.addFlight();
                    break;
                case 2:
                    menuActions.showFlights();
                    break;
                case 3:
                    menuActions.updateFlight();
                    break;
                case 4:
                    menuActions.searchFlight();
                    break;
                case 5:
                    System.out.println("Send Email");
                    break;
                case 6:
                    menuActions.exportExcel();
                    break;
                case 7:
                    System.out.println("Bye-bye");
                    System.exit(0);
                    break;
            }

        }
    }


}
