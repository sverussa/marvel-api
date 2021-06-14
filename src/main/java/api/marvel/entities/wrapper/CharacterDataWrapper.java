package api.marvel.entities.wrapper;

import api.marvel.entities.container.CharacterDataContainer;
import lombok.Data;

@Data
public class CharacterDataWrapper extends DataWrapper  {

//    private int code = 200;
//    private String status = "Ok";
//    private String copyright = "© 2021 MARVEL";
//    private String attributionText = "Data provided by Marvel. © 2021 MARVEL";
//    private String attributionHTML = "<a href=\"http://marvel.com\">Data provided by Marvel. © 2021 MARVEL</a>";
//    private String etag;

    private CharacterDataContainer data;
}
