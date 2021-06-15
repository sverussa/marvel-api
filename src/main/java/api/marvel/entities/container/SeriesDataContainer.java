package api.marvel.entities.container;

import api.marvel.entities.Series;
import lombok.Data;

import java.util.List;

@Data
public class SeriesDataContainer {

    private List<Series> results;
}
