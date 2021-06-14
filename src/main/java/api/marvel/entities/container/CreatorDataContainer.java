package api.marvel.entities.container;

import api.marvel.entities.Creator;
import lombok.Data;

import java.util.List;

@Data
public class CreatorDataContainer extends DataContainer {

    private List<Creator> results;

}
