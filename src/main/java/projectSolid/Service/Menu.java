package projectSolid.Service;

import java.util.Scanner;

public class Menu {

    StringBuilder sb = new StringBuilder();
    Scanner scanner = new Scanner(System.in);
    MenuActions menuActions = new MenuActions();

    private static Menu get_Instance = null;
    private Menu () {};

    public static Menu getInstance(){

        if (get_Instance == null)
                get_Instance= new Menu();
        return get_Instance;
    }


    public void showMenu() {


        int option;

        while(true){
            /*sb.setLength(0);
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
            System.out.println(sb);*/
            loadMenu();

            option  = Integer.parseInt(scanner.next());
            menuActions.setValues();
            switch (option) {
                case 1 -> menuActions.addFlight();
                case 2 -> menuActions.showFlights();
                case 3 -> menuActions.updateFlight();
                case 4 -> menuActions.searchFlight();
                case 5 -> {
                    System.out.println("Bye-bye");
                    System.exit(0);
                }
                default -> System.out.println("invalid option");
            }

        }
    }

    public void loadMenu(){
        sb.setLength(0);
        sb.append("-----------------------------------------\n");
        sb.append("FLIGHTS MANAGER\n");
        sb.append("Select an option\n");
        sb.append("1. Add flight\n");
        sb.append("2. Flights list\n");
        sb.append("3. Update flights\n");
        sb.append("4. Search flight\n");
        sb.append("5. Exit\n");
        sb.append("------------------------------------------\n");
        System.out.println(sb);
    }


}
