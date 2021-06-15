package api.marvel.service;

import api.marvel.entities.Story;
import api.marvel.validation.Parameters;

public interface StoriesService {

    Story find(Parameters parameters);

    Story findById(Integer id, Parameters parameters);

    Story save(Story story);
}
