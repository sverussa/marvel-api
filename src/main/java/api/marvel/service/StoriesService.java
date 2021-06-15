package api.marvel.service;

import api.marvel.entities.Story;
import api.marvel.entities.container.StoryDataContainer;
import api.marvel.entities.list.StoryList;
import api.marvel.validation.Parameters;

public interface StoriesService {

    StoryDataContainer find(Parameters parameters);

    StoryDataContainer findByIdCharacter(Integer idCharacter, Parameters parameters);

    StoryList findSummaryByIdCharacter(Integer idCharacter);

    Story save(Story series);
}
