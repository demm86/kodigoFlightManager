package projectSolid;

import lombok.Data;

@Data
public class City {

    private int id;
    private String code;
    private String name;
    private Country country;

}
