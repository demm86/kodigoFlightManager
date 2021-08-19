package projectSolid.Interfaces;

import projectSolid.Entities.Note;
import projectSolid.Entities.Airport;

import java.util.List;

public interface INoteServices {
    List<Note> setNote();
    void printElements(List<Note> list);
}
