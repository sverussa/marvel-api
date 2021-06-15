package api.marvel.service;

import api.marvel.entities.Comic;
import api.marvel.entities.Serie;
import api.marvel.validation.Parameters;

public interface SeriesService {

    Serie find(Parameters parameters);

    Comic findById(Integer id, Parameters parameters);

    Serie save(Serie serie);
}
