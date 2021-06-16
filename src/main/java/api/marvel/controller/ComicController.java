package api.marvel.controller;

import api.marvel.entities.container.ComicDataContainer;
import api.marvel.entities.wrapper.ComicDataWrapper;
import api.marvel.service.ComicsService;
import api.marvel.util.MarvelGson;
import api.marvel.validation.Parameters;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log
@RestController
@RequestMapping("/v1/public/characters")
public class ComicController {

    @Autowired
    ComicsService comicsService;

    @GetMapping(path = "/{characterId}/comics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCharacterIdComics(@PathVariable("characterId") int characterId, @Valid Parameters parameters) throws JsonProcessingException {
        log.info("Comic Controller CharacterId: " + characterId);
        ComicDataContainer comicDataContainer = comicsService.findByIdCharacter(characterId, parameters);
        ComicDataWrapper comicDataWrapper = new ComicDataWrapper();
        comicDataWrapper.setData(comicDataContainer);
        return ResponseEntity.ok(MarvelGson.getGson().toJson(comicDataWrapper));
    }
}
