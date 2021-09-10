package projectSolid;

import org.junit.jupiter.api.Test;
import projectSolid.Service.Menu;


public class Main {


    public static void main(String[] args){

        Menu menu = Menu.getInstance();
        menu.showMenu();

    }
}