package api.marvel.service.impl;

import api.marvel.entities.Series;
import api.marvel.entities.container.SeriesDataContainer;
import api.marvel.entities.list.SeriesList;
import api.marvel.repository.SeriesRepository;
import api.marvel.service.SeriesService;
import api.marvel.validation.Parameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
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
        return seriesRepository.save(series);
    }
}
