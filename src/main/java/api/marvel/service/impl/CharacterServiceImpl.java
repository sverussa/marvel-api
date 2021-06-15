package api.marvel.service.impl;

import api.marvel.entities.Character;
import api.marvel.entities.Comic;
import api.marvel.entities.container.CharacterDataContainer;
import api.marvel.entities.list.ComicList;
import api.marvel.entities.summary.ComicSummary;
import api.marvel.repository.CharacterRepository;
import api.marvel.repository.ComicsRepository;
import api.marvel.service.CharacterService;
import api.marvel.validation.Parameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Log4j2
@Service
public class CharacterServiceImpl implements CharacterService {

    CharacterRepository characterRepository;

    ComicsRepository comicsRepository;

    @Autowired
    public void setCharacterRepository(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Autowired
    public void setComicsRepository(ComicsRepository comicsRepository) {
        this.comicsRepository = comicsRepository;
    }

    public CharacterDataContainer find(Parameters parameters) {
        List<Character> characters = characterRepository.findAll();
        for (Character character : characters) {
            List<Comic> comics = comicsRepository.findAllByIdCharacterEquals(character.getId());
            log.info(comics.size());
        }

        CharacterDataContainer characterDataContainer = new CharacterDataContainer();
        characterDataContainer.setResults(characters);
        return characterDataContainer;
    }

    @Override
    public CharacterDataContainer findById(Integer id, Parameters parameters) {
        Character character = characterRepository.findById(id).orElse(null);
        List<Comic> comics = comicsRepository.findAllByIdCharacterEquals(character.getId());
        log.info(comics.size());

        ComicList comicList = new ComicList();
        comicList.setAvailable(comics.size());
        for (Comic comic : comics) {
            ComicSummary comicSummary = comic.getSummary();
            comicList.getItems().add(comicSummary);
        }

        character.setComics(comicList);

        CharacterDataContainer characterDataContainer = new CharacterDataContainer();
        characterDataContainer.setResults(Arrays.asList(character));
        return characterDataContainer;
    }

    @Override
    public Character save(Character character) {
        return characterRepository.save(character);
    }
}
