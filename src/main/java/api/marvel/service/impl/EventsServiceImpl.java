package api.marvel.service.impl;

import api.marvel.entities.Event;
import api.marvel.entities.container.EventDataContainer;
import api.marvel.entities.list.EventList;
import api.marvel.entities.summary.EventSummary;
import api.marvel.repository.EventsRepository;
import api.marvel.service.EventsService;
import api.marvel.validation.Parameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    EventsRepository eventsRepository;

    @Override
    public EventDataContainer find(Parameters parameters) {
        List<Event> events = eventsRepository.findAll();
        EventDataContainer eventDataContainer = new EventDataContainer();
        eventDataContainer.setResults(events);
        return eventDataContainer;
    }

    @Override
    public EventDataContainer findByIdCharacter(Integer idCharacter, Parameters parameters) {
        List<Event> events = eventsRepository.findAllByIdCharacterEquals(idCharacter);
        EventDataContainer eventDataContainer = new EventDataContainer();
        eventDataContainer.setResults(events);
        return eventDataContainer;
    }

    @Override
    public EventList findSummaryByIdCharacter(Integer idCharacter) {
        List<Event> events = eventsRepository.findAllByIdCharacterEquals(idCharacter);
        EventList eventList = new EventList();
        for (Event event : events) {
            eventList.getItems().add(new EventSummary(event.getTitle()));
        }
        return eventList;
    }

    @Override
    public Event save(Event event) {
        return eventsRepository.save(event);
    }
}
