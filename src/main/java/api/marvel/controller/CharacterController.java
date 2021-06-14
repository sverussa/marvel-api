package api.marvel.controller;


import api.marvel.entities.Character;
import api.marvel.entities.container.CharacterDataContainer;
import api.marvel.entities.wrapper.CharacterDataWrapper;
import api.marvel.service.CharacterService;
import api.marvel.validation.Parameters;
import com.google.gson.Gson;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Log
@Validated
@RestController
@RequestMapping("/v1/public/characters")
public class CharacterController {

/*    Endpoints a serem implementados:

        /v1/public/characters
        /v1/public/characters/{characterId}
        /v1/public/characters/{characterId}/comics
        /v1/public/characters/{characterId}/events
        /v1/public/characters/{characterId}/series
        /v1/public/characters/{characterId}/stories

*/
    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

//    @Validated
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getMarvelCharacter(@Valid Parameters parameters) {

        System.out.println(parameters);

        List<Character> characters = characterService.find();
        CharacterDataContainer characterDataContainer = new CharacterDataContainer();
        characterDataContainer.setResults(characters);

        CharacterDataWrapper characterDataWrapper = new CharacterDataWrapper();
        characterDataWrapper.setData(characterDataContainer);

        return ResponseEntity.ok(new Gson().toJson(characterDataWrapper));
    }

    @GetMapping(path = "/{characterId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCharacterId(@PathVariable("characterId") int characterId, @RequestParam Map<String, String> parameters) {
        log.info("CharacterId: " + characterId);
        return null;
    }
}