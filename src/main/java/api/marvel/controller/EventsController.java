package api.marvel.controller;

import api.marvel.entities.container.EventDataContainer;
import api.marvel.entities.wrapper.EventDataWrapper;
import api.marvel.service.EventsService;
import api.marvel.util.MarvelGson;
import api.marvel.validation.Parameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping("/v1/public/characters")
public class EventsController {

    @Autowired
    EventsService eventsService;

    @GetMapping(path = "/{characterId}/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCharacterIdEvents(@PathVariable("characterId") int characterId, @Valid Parameters parameters) {
        log.info("Event Controller CharacterId: " + characterId);
        EventDataContainer dataContainer = eventsService.findByIdCharacter(characterId, parameters);
        EventDataWrapper dataWrapper = new EventDataWrapper();
        dataWrapper.setData(dataContainer);
        return ResponseEntity.ok(MarvelGson.getGson().toJson(dataWrapper));
    }
}
