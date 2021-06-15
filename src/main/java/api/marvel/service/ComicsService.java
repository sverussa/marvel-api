package api.marvel.service;

import api.marvel.entities.Comic;
import api.marvel.entities.container.ComicDataContainer;
import api.marvel.validation.Parameters;

public interface ComicsService {

    ComicDataContainer find(Parameters parameters);

    ComicDataContainer findByIdCharacter(Integer idCharacter, Parameters parameters);

    Comic save(Comic comic);

}
