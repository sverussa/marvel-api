package api.marvel.controller;

import lombok.extern.java.Log;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Log
@RestController
@RequestMapping("/v1/public/characters")
public class SeriesController {

    @GetMapping(path = "/{characterId}/series", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCharacterIdSeries(@PathVariable("characterId") int characterId, @RequestParam Map<String, String> parameters) {
        log.info("CharacterId: " + characterId);
        return null;
    }
}
