package api.marvel.controller;

import api.marvel.entities.container.StoryDataContainer;
import api.marvel.entities.wrapper.StoryDataWrapper;
import api.marvel.service.StoriesService;
import api.marvel.util.MarvelGson;
import api.marvel.validation.Parameters;
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
public class StoriesController {

    @Autowired
    StoriesService storiesService;

    @GetMapping(path = "/{characterId}/stories", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCharacterIdStories(@PathVariable("characterId") int characterId, @Valid Parameters parameters) {
        log.info("Stories Controller CharacterId: " + characterId);
        StoryDataContainer dataContainer = storiesService.findByIdCharacter(characterId, parameters);
        StoryDataWrapper dataWrapper = new StoryDataWrapper();
        dataWrapper.setData(dataContainer);
        return ResponseEntity.ok(MarvelGson.getGson().toJson(dataWrapper));
    }
}
