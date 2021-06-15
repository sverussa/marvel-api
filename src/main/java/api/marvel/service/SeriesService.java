package api.marvel.service;

import api.marvel.entities.Comic;
import api.marvel.entities.Series;
import api.marvel.validation.Parameters;

public interface SeriesService {

    Series find(Parameters parameters);

    Comic findById(Integer id, Parameters parameters);

    Series save(Series serie);
}
