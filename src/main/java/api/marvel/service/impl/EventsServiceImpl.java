package api.marvel.service.impl;

import api.marvel.entities.Event;
import api.marvel.entities.container.EventDataContainer;
import api.marvel.entities.list.EventList;
import api.marvel.repository.EventsRepository;
import api.marvel.service.EventsService;
import api.marvel.validation.Parameters;
import org.springframework.beans.factory.annotation.Autowired;

public class EventsServiceImpl implements EventsService {

    @Autowired
    EventsRepository eventsRepository;

    @Override
    public EventDataContainer find(Parameters parameters) {
        return null;
    }

    @Override
    public EventDataContainer findByIdCharacter(Integer idCharacter, Parameters parameters) {
        return null;
    }

    @Override
    public EventList findSummaryByIdCharacter(Integer idCharacter) {
        return null;
    }

    @Override
    public Event save(Event event) {
        return null;
    }
}
