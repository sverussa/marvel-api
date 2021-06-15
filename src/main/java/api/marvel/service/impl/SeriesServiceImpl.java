package api.marvel.service.impl;

import api.marvel.entities.Series;
import api.marvel.entities.container.SeriesDataContainer;
import api.marvel.entities.list.SeriesList;
import api.marvel.repository.SeriesRepository;
import api.marvel.service.SeriesService;
import api.marvel.validation.Parameters;
import org.springframework.beans.factory.annotation.Autowired;

public class SeriesServiceImpl implements SeriesService {

    @Autowired
    SeriesRepository seriesRepository;

    @Override
    public SeriesDataContainer find(Parameters parameters) {
        return null;
    }

    @Override
    public SeriesDataContainer findByIdCharacter(Integer idCharacter, Parameters parameters) {
        return null;
    }

    @Override
    public SeriesList findSummaryByIdCharacter(Integer idCharacter) {
        return null;
    }

    @Override
    public Series save(Series series) {
        return null;
    }
}
