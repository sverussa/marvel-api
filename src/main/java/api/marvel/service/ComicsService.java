package api.marvel.service;

import api.marvel.entities.Comic;
import api.marvel.entities.container.ComicDataContainer;
import api.marvel.entities.list.ComicList;
import api.marvel.validation.Parameters;

public interface ComicsService {

    ComicDataContainer find(Parameters parameters);

    ComicDataContainer findByIdCharacter(Integer idCharacter, Parameters parameters);

    ComicList findSummaryByIdCharacter(Integer idCharacter);

    Comic save(Comic comic);

}
