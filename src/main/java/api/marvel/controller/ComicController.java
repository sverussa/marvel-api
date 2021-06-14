package api.marvel.controller;

import lombok.extern.java.Log;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Log
@RestController
@RequestMapping("/v1/public/characters")
public class ComicController {


    @GetMapping(path = "/{characterId}/comics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCharacterIdComics(@PathVariable("characterId") int characterId, @RequestParam Map<String, String> parameters) {
        log.info("CharacterId: " + characterId);
        return null;
    }
}
