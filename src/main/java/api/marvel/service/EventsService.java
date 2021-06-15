package api.marvel.service;

import api.marvel.entities.Comic;
import api.marvel.entities.Event;
import api.marvel.validation.Parameters;

public interface EventsService {

    Event find(Parameters parameters);

    Event findById(Integer id, Parameters parameters);

    Event save(Event event);
}
