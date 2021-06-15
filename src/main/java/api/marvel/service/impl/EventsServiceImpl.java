package api.marvel.service.impl;

import api.marvel.entities.Event;
import api.marvel.entities.container.EventDataContainer;
import api.marvel.entities.list.EventList;
import api.marvel.repository.EventsRepository;
import api.marvel.service.EventsService;
import api.marvel.validation.Parameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
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
        return eventsRepository.save(event);
    }
}
