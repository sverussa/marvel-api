package api.marvel.service.impl;

import api.marvel.entities.Series;
import api.marvel.entities.container.SeriesDataContainer;
import api.marvel.entities.list.SeriesList;
import api.marvel.entities.summary.SeriesSummary;
import api.marvel.repository.SeriesRepository;
import api.marvel.service.SeriesService;
import api.marvel.validation.Parameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class SeriesServiceImpl implements SeriesService {

    @Autowired
    SeriesRepository seriesRepository;

    @Override
    public SeriesDataContainer find(Parameters parameters) {
        List<Series> series = seriesRepository.findAll();
        SeriesDataContainer seriesDataContainer = new SeriesDataContainer();
        seriesDataContainer.setResults(series);
        return seriesDataContainer;
    }

    @Override
    public SeriesDataContainer findByIdCharacter(Integer idCharacter, Parameters parameters) {
        List<Series> series = seriesRepository.findAllByIdCharacterEquals(idCharacter);
        SeriesDataContainer seriesDataContainer = new SeriesDataContainer();
        seriesDataContainer.setResults(series);
        return seriesDataContainer;
    }

    @Override
    public SeriesList findSummaryByIdCharacter(Integer idCharacter) {
        List<Series> series = seriesRepository.findAllByIdCharacterEquals(idCharacter);
        SeriesList seriesList = new SeriesList();
        for (Series serie : series) {
            seriesList.getItems().add(new SeriesSummary(serie.getTitle()));
        }
        return seriesList;
    }

    @Override
    public Series save(Series series) {
        return seriesRepository.save(series);
    }
}
