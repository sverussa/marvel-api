package api.marvel.entities.wrapper;

import api.marvel.entities.container.ComicDataContainer;
import lombok.Data;

@Data
public class ComicDataWrapper extends DataWrapper {

    private ComicDataContainer data;

}
