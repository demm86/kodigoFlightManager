package projectSolid.Entities;

import lombok.Data;

@Data
public class Airline {
    private int id;
    private String code;
    private String name;
    private Country country;
}
