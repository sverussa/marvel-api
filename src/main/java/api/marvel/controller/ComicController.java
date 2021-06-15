package api.marvel.controller;

import api.marvel.entities.container.ComicDataContainer;
import api.marvel.entities.wrapper.ComicDataWrapper;
import api.marvel.service.ComicsService;
import api.marvel.validation.Parameters;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
public class ComicController {

    @Autowired
    ComicsService comicsService;

    @GetMapping(path = "/{characterId}/comics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCharacterIdComics(@PathVariable("characterId") int characterId, @Valid Parameters parameters) throws JsonProcessingException {
        log.info("CharacterId: " + characterId);
        ComicDataContainer comicDataContainer = comicsService.findByIdCharacter(characterId, parameters);
        ComicDataWrapper comicDataWrapper = new ComicDataWrapper();
        comicDataWrapper.setData(comicDataContainer);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(comicDataWrapper);
        return ResponseEntity.ok(json);
    }
}
