package api.marvel.service.impl;

import api.marvel.entities.Story;
import api.marvel.entities.container.StoryDataContainer;
import api.marvel.entities.list.StoryList;
import api.marvel.repository.StoriesRepository;
import api.marvel.service.StoriesService;
import api.marvel.validation.Parameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class StoriesServiceImpl implements StoriesService {

    @Autowired
    StoriesRepository storiesRepository;

    @Override
    public StoryDataContainer find(Parameters parameters) {
        return null;
    }

    @Override
    public StoryDataContainer findByIdCharacter(Integer idCharacter, Parameters parameters) {
        return null;
    }

    @Override
    public StoryList findSummaryByIdCharacter(Integer idCharacter) {
        return null;
    }

    @Override
    public Story save(Story series) {
        return null;
    }
}
