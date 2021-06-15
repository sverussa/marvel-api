package api.marvel.service;

import api.marvel.entities.Event;
import api.marvel.entities.container.EventDataContainer;
import api.marvel.entities.list.EventList;
import api.marvel.validation.Parameters;

public interface EventsService {

    EventDataContainer find(Parameters parameters);

    EventDataContainer findByIdCharacter(Integer idCharacter, Parameters parameters);

    EventList findSummaryByIdCharacter(Integer idCharacter);

    Event save(Event event);
}
