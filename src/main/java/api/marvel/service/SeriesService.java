package api.marvel.service;

import api.marvel.entities.Series;
import api.marvel.entities.container.SeriesDataContainer;
import api.marvel.entities.list.SeriesList;
import api.marvel.validation.Parameters;

public interface SeriesService {

    SeriesDataContainer find(Parameters parameters);

    SeriesDataContainer findByIdCharacter(Integer idCharacter, Parameters parameters);

    SeriesList findSummaryByIdCharacter(Integer idCharacter);

    Series save(Series series);
}
