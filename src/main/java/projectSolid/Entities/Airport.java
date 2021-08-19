package projectSolid.Entities;

import lombok.Data;

@Data
public class Airport {
    private int id;
    private String code;
    private String name;
    private City city;
}
