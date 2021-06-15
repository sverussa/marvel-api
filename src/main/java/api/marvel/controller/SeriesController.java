package api.marvel.controller;

import api.marvel.entities.container.EventDataContainer;
import api.marvel.entities.container.SeriesDataContainer;
import api.marvel.entities.wrapper.EventDataWrapper;
import api.marvel.entities.wrapper.SeriesDataWrapper;
import api.marvel.service.EventsService;
import api.marvel.service.SeriesService;
import api.marvel.util.MarvelGson;
import api.marvel.validation.Parameters;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Log
@RestController
@RequestMapping("/v1/public/characters")
public class SeriesController {

    @Autowired
    SeriesService serviceService;

    @GetMapping(path = "/{characterId}/series", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCharacterIdSeries(@PathVariable("characterId") int characterId, @Valid Parameters parameters) {
        log.info("Series Controller CharacterId: " + characterId);
        SeriesDataContainer dataContainer = serviceService.findByIdCharacter(characterId, parameters);
        SeriesDataWrapper dataWrapper = new SeriesDataWrapper();
        dataWrapper.setData(dataContainer);
        return ResponseEntity.ok(MarvelGson.getGson().toJson(dataWrapper));
    }
}
