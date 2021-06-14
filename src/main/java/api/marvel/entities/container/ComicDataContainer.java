package api.marvel.entities.container;

import api.marvel.entities.Comic;
import lombok.Data;

import java.util.List;

@Data
public class ComicDataContainer extends DataContainer {

    private List<Comic> results;

}
