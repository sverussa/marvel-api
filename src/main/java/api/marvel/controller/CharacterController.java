package api.marvel.controller;


import api.marvel.entities.container.CharacterDataContainer;
import api.marvel.entities.wrapper.CharacterDataWrapper;
import api.marvel.service.CharacterService;
import api.marvel.util.MarvelGson;
import api.marvel.validation.Parameters;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log4j2
@Validated
@RestController
@RequestMapping("/v1/public/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getMarvelCharacter(@Valid Parameters parameters) {
        log.info("Parameters:" + parameters);

        CharacterDataContainer characterDataContainer  = characterService.find(parameters);
        CharacterDataWrapper characterDataWrapper = new CharacterDataWrapper();
        characterDataWrapper.setData(characterDataContainer);
        return ResponseEntity.ok(new Gson().toJson(characterDataWrapper));
    }

    @GetMapping(path = "/{characterId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCharacterId(@PathVariable("characterId") int characterId,
                                                 @Valid Parameters parameters) throws JsonProcessingException {
        log.info("CharacterId: " + characterId);
        log.info("Parameters:" + parameters);

        CharacterDataContainer characterDataContainer  = characterService.findById(characterId, parameters);
        CharacterDataWrapper characterDataWrapper = new CharacterDataWrapper();
        characterDataWrapper.setData(characterDataContainer);

        return ResponseEntity.ok(MarvelGson.getGson().toJson(characterDataWrapper));
    }
}