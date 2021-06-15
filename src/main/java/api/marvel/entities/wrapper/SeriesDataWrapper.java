package api.marvel.entities.wrapper;

import api.marvel.entities.container.SeriesDataContainer;
import lombok.Data;

@Data
public class SeriesDataWrapper extends DataWrapper{

    private SeriesDataContainer data;

}
