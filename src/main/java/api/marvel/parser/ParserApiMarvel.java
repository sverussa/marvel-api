package api.marvel.parser;

import api.marvel.entities.Character;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Component
public class ParserApiMarvel {

    @Autowired
    MarvelParserCharacter marvelParserCharacter;
    @Autowired
    MarvelParserComic marvelParserComic;

    public void parserApi() throws ParseException {

        marvelParserCharacter.parse();
        marvelParserCharacter.insert();
        List<Character> characters = marvelParserCharacter.getCharacters();

        List<Integer> idCharacters = characters.stream().map(Character::getId).collect(Collectors.toList());
        marvelParserComic.setIdCharacters(idCharacters);
        marvelParserComic.parse();
        marvelParserComic.insert();

        log.info(new Gson().toJson("Sucesso Parser Marvel Character"));
    }
}