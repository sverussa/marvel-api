package api.marvel.entities.wrapper;

import api.marvel.entities.container.CharacterDataContainer;
import lombok.Data;

@Data
public class CharacterDataWrapper extends DataWrapper  {

    private CharacterDataContainer data;

}
