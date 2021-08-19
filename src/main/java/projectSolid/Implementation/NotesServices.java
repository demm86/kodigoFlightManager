package projectSolid.Implementation;

import projectSolid.Entities.Airport;
import projectSolid.Entities.Note;
import projectSolid.Interfaces.INoteServices;

import java.util.List;

public class NotesServices implements INoteServices {
    @Override
    public List<Note> setNote() {
        return null;
    }

    @Override
    public void printElements(List<Note> list) {
        System.out.println("Note list:");
        System.out.println("---------------------------------");
        for (Note Note: list) {
            System.out.println("ID: " + Note.getId() + "\n" +
                    "Code: " + Note.getCode() + "\n"+
                    "Name: " + Note.getName() + "\n"+
                    "Flight: " + Note.getFlight() + "\n"+
                    "Flight Status: " + Note.getFlightStatus() + "\n"+
                    "Note: " + Note.getNote() + "\n"
            );

            System.out.println("---------------------------------");
            System.out.println();

        }
    }
}
