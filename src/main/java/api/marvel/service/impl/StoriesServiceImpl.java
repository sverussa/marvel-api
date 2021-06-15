package api.marvel.service.impl;

import api.marvel.entities.Story;
import api.marvel.entities.container.StoryDataContainer;
import api.marvel.entities.list.StoryList;
import api.marvel.entities.summary.StorySummary;
import api.marvel.repository.StoriesRepository;
import api.marvel.service.StoriesService;
import api.marvel.validation.Parameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class StoriesServiceImpl implements StoriesService {

    @Autowired
    StoriesRepository storiesRepository;

    @Override
    public StoryDataContainer find(Parameters parameters) {
        List<Story> stories = storiesRepository.findAll();
        StoryDataContainer storyDataContainer = new StoryDataContainer();
        storyDataContainer.setResults(stories);
        return storyDataContainer;
    }

    @Override
    public StoryDataContainer findByIdCharacter(Integer idCharacter, Parameters parameters) {
        List<Story> stories = storiesRepository.findAllByIdCharacterEquals(idCharacter);
        StoryDataContainer storyDataContainer = new StoryDataContainer();
        storyDataContainer.setResults(stories);
        return storyDataContainer;
    }

    @Override
    public StoryList findSummaryByIdCharacter(Integer idCharacter) {
        List<Story> stories = storiesRepository.findAllByIdCharacterEquals(idCharacter);
        StoryList storyList = new StoryList();
        for (Story story : stories) {
            storyList.getItems().add(new StorySummary(story.getTitle()));
        }
        return storyList;
    }

    @Override
    public Story save(Story story) {
        return storiesRepository.save(story);
    }
}
