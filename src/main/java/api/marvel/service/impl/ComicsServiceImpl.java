package api.marvel.service.impl;

import api.marvel.entities.Comic;
import api.marvel.entities.container.ComicDataContainer;
import api.marvel.entities.list.ComicList;
import api.marvel.entities.summary.ComicSummary;
import api.marvel.repository.ComicsRepository;
import api.marvel.service.ComicsService;
import api.marvel.validation.Parameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class ComicsServiceImpl implements ComicsService {

    @Autowired
    ComicsRepository comicsRepository;

    @Override
    public ComicDataContainer find(Parameters parameters) {
        List<Comic> comics = comicsRepository.findAll();
        ComicDataContainer comicDataContainer = new ComicDataContainer();
        comicDataContainer.setResults(comics);
        return comicDataContainer;
    }

    @Override
    public ComicDataContainer findByIdCharacter(Integer id, Parameters parameters) {
        List<Comic> comics = comicsRepository.findAllByIdCharacterEquals(id);
        ComicDataContainer comicDataContainer = new ComicDataContainer();
        comicDataContainer.setResults(comics);
        return comicDataContainer;
    }

    @Override
    public ComicList findSummaryByIdCharacter(Integer idCharacter) {
        List<Comic> comics = comicsRepository.findAllByIdCharacterEquals(idCharacter);
        ComicList comicList = new ComicList();
        for (Comic comic : comics) {
            comicList.getItems().add(new ComicSummary(comic.getTitle()));
        }
        return comicList;
    }

    @Override
    public Comic save(Comic comic) {
        return comicsRepository.save(comic);
    }

}
