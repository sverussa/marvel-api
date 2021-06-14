package api.marvel.entities.container;

import api.marvel.entities.Character;
import lombok.Data;

import java.util.List;

@Data
public class CharacterDataContainer extends DataContainer {

    private List<Character> results;

}
