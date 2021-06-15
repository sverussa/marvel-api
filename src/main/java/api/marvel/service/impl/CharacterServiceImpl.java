package api.marvel.service.impl;

import api.marvel.entities.Character;
import api.marvel.entities.container.CharacterDataContainer;
import api.marvel.entities.list.ComicList;
import api.marvel.entities.list.EventList;
import api.marvel.entities.list.SeriesList;
import api.marvel.entities.list.StoryList;
import api.marvel.repository.CharacterRepository;
import api.marvel.service.*;
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

    ComicsService comicsService;
    EventsService eventsService;
    SeriesService seriesService;
    StoriesService storiesService;

    @Autowired
    public void setEventsService(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @Autowired
    public void setSeriesService(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @Autowired
    public void setStoriesService(StoriesService storiesService) {
        this.storiesService = storiesService;
    }

    @Autowired
    public void setCharacterRepository(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Autowired
    public void setComicsService(ComicsService comicsService) {
        this.comicsService = comicsService;
    }

    public CharacterDataContainer find(Parameters parameters) {
        List<Character> characters = characterRepository.findAll();
        for (Character character : characters) {
            ComicList comics = comicsService.findSummaryByIdCharacter(character.getId());
            EventList events = eventsService.findSummaryByIdCharacter(character.getId());
            StoryList stories = storiesService.findSummaryByIdCharacter(character.getId());
            SeriesList series = seriesService.findSummaryByIdCharacter(character.getId());
            character.setComics(comics);
            character.setEvents(events);
            character.setStories(stories);
            character.setSeries(series);
        }

        CharacterDataContainer characterDataContainer = new CharacterDataContainer();
        characterDataContainer.setResults(characters);
        return characterDataContainer;
    }

    @Override
    public CharacterDataContainer findById(Integer id, Parameters parameters) {
        Character character = characterRepository.findById(id).orElse(null);

        ComicList comics = comicsService.findSummaryByIdCharacter(character.getId());
        EventList events = eventsService.findSummaryByIdCharacter(character.getId());
        StoryList stories = storiesService.findSummaryByIdCharacter(character.getId());
        SeriesList series = seriesService.findSummaryByIdCharacter(character.getId());
        character.setComics(comics);
        character.setEvents(events);
        character.setStories(stories);
        character.setSeries(series);

        CharacterDataContainer characterDataContainer = new CharacterDataContainer();
        characterDataContainer.setResults(Arrays.asList(character));
        return characterDataContainer;
    }

    @Override
    public Character save(Character character) {
        return characterRepository.save(character);
    }
}
